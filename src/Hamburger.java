import java.util.Scanner;

public class Hamburger {

    private String type;
    private double price;
    private boolean extraToppings;
    private int toppingCap;

    public Hamburger() {
    }

    public Hamburger(String type, double price, int toppingCap) {
        this.type = type;
        this.price = price;
        this.toppingCap = toppingCap;
        switch (type.toLowerCase()) {
            case "cheeseburger":

            case "bacon":

            case "deluxe":
                this.extraToppings = true;
                break;

            default:
                this.extraToppings = false;
                break;
        }
    }

    public void setToppingCap(int toppingCap) {
        this.toppingCap = toppingCap;
    }

    public void setExtraToppings(String type) {
        switch (type.toLowerCase()) {
            case "cheeseburger":

            case "bacon":

            case "deluxe":
                this.extraToppings = true;
                break;

            default:
                this.extraToppings = false;
                break;
        }
    }

    public void setPrice(String type) {
        switch (type.toLowerCase()) {
            case "cheeseburger":

                this.price = 3.00;
                break;

            case "bacon":

                this.price = 3.50;
                break;

            default:
                this.price = 2.00;
                break;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void getOverallPrice() {
        boolean validAnswer = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like some extra toppings to the burger? Y/N");
        String input = scanner.nextLine().toLowerCase();

        if (!(input.charAt(0) == 'y') && !(input.charAt(0) == 'n')) {
            do {
                System.out.println("Incorrect answer. Please choose valid option: Y/N");
                input = scanner.nextLine().toLowerCase();
                if ((input.charAt(0) == 'y') || (input.charAt(0) == 'n')) {
                    validAnswer = true;
                }
            } while (!validAnswer);
        } else if ((input.charAt(0) == 'y')) {
            getExtraToppings();
        } else {
            System.out.println("Thank you for choosing your option.");
        }
    }

    protected void getExtraToppings() {
        StringBuilder toppingName = new StringBuilder();
        double cheapTopping = 0.25;
        double mediumTopping = 0.5;
        double expensiveTopping = 0.7;

        if (extraToppings) {
            int counter = 0;

            System.out.println("Please choose one of the following toppings:\n\n1. Extra cheese\n2. Extra onion\n" +
                    "3. Extra pickle\n4. Extra tomato\n5. Extra bacon\n6. Extra lettuce\n7. Extra egg\n8. No more toppings");
            while (counter < toppingCap) {
                Scanner scanner = new Scanner(System.in);

                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        addToppingPrice(expensiveTopping, new StringBuilder("extra cheese\n"));
                        break;

                    case 5:
                        addToppingPrice(expensiveTopping, new StringBuilder("extra bacon\n"));
                        break;

                    case 7:
                        addToppingPrice(expensiveTopping, new StringBuilder("extra egg\n"));
                        counter++;
                        break;

                    case 2:
                        addToppingPrice(cheapTopping, new StringBuilder("extra onion\n"));
                        counter++;
                        break;


                    case 3:
                        addToppingPrice(cheapTopping, new StringBuilder("extra pickle\n"));
                        counter++;
                        break;

                    case 4:
                        addToppingPrice(mediumTopping, new StringBuilder("extra tomato\n"));
                        counter++;
                        break;

                    case 6:
                        addToppingPrice(mediumTopping, new StringBuilder("extra lettuce\n"));
                        counter++;
                        break;

                    case 8:
                        System.out.println("All toppings have been chosen.");
                        counter = 3;
                        break;

                    default:
                        invalidInput(0, 9);
                }
            }

        } else {
            System.out.println("Unable to process the order. The requested type does not support extra toppings.");
        }

        System.out.println("Thank you for choosing. The toppings you have chosen are:\n\n" + toppingName);
    }

    public void invalidInput(int minOption, int maxOption) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.println("Incorrect option. Please choose option from " + (minOption + 1) + " to " + (maxOption - 1) + ".\n");
            int input = scanner.nextInt();
            if (input > 0 && input < 8) {
                validInput = true;
            }
        } while (!validInput);
    }

    public void addToppingPrice(double toppingType, StringBuilder toppingName) {
        this.price += toppingType;
        toppingName.append(toppingName);
        System.out.println("Please choose a topping.\n");
    }
}
