import java.util.Scanner;

public class Order {

    private Hamburger hamburger;
    private final Drink drink;
    private final Side side;
    private double price;

    public Order(Hamburger hamburger, Drink drink, Side side) {
        this.hamburger = hamburger;
        this.drink = drink;
        this.side = side;
        this.price = (hamburger.getPrice() + drink.getPrice() + side.getPrice());
    }

    public double getPrice() {
        return price;
    }

    public void orderMeal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Artur's Burgers!");
        while (true) {
            System.out.println("Please choose your order:\n\n1. Burger\n2. Drink\n3. Side\n4. Done\n");
            int input = scanner.nextInt();
            if (input == 4) {
                System.out.println("Thank you for your order! The total price is " + getPrice() + ".");
                return;
            } else {
                switch (input) {
                    case 1:
                        System.out.println("Please choose from the following burgers:\n\n1. Cheeseburger\n2. Bacon burger\n3. Deluxe Burger\n4. Basic burger");
                        input = scanner.nextInt();
                        switch (input) {
                            case 1:
                                addHamburgerPrice("cheeseburger");
                                hamburger.getOverallPrice();
                                this.price += hamburger.getPrice();
                                break;

                            case 2:
                                addHamburgerPrice("bacon");
                                hamburger.getOverallPrice();
                                this.price += hamburger.getPrice();
                                break;

                            case 3:
                                hamburger = new DeluxeBurger();
                                hamburger.getOverallPrice();
                                this.price += hamburger.getPrice();
                                break;

                            case 4:
                                addHamburgerPrice("basic");
                                hamburger.getOverallPrice();
                                this.price += hamburger.getPrice();
                                break;

                            default:
                                invalidInput(0, 5);
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("Please choose from the following drinks:\n\n1. Fanta\n2. Pepsi\n3. Ice Tea\n4. Water");
                        input = scanner.nextInt();
                        switch (input) {
                            case 1:
                                addDrinkPrice("fanta");
                                break;

                            case 2:
                                addDrinkPrice("cocaCola");
                                break;

                            case 3:
                                addDrinkPrice("iceTea");
                                break;

                            case 4:
                                addDrinkPrice("water");
                                break;

                            default:
                                invalidInput(0, 5);
                                break;
                        }
                        break;

                    case 3:
                        System.out.println("Please choose from the following sides:\n\n1. Apple\n2. Fries\n3. Nuggets;");
                        input = scanner.nextInt();
                        switch (input) {
                            case 1:
                                addSidePrice("apple");
                                break;

                            case 2:
                                addSidePrice("fries");
                                break;

                            case 3:
                                addSidePrice("nuggets");
                                break;

                            default:
                                invalidInput(0, 4);
                                break;
                        }

                    default:
                        invalidInput(0, 5);
                        break;
                }
            }
        }

    }

    public void addHamburgerPrice(String type) {
        hamburger.setType(type);
        hamburger.setPrice(type);
        hamburger.setExtraToppings(type);
        hamburger.setToppingCap(3);
        hamburger.getOverallPrice();
        this.price += hamburger.getPrice();
    }

    public void addDrinkPrice(String type) {
        drink.setType(type);
        drink.chooseSize(drink.getType());
        drink.setPrice(type);
        this.price += drink.getPrice();
    }

    public void addSidePrice(String type) {
        side.setType(type);
        side.setPrice(type);
        this.price += side.getPrice();
    }

    public void invalidInput(int minOption, int maxOption) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.println("Incorrect option. Please choose option from " + minOption + " to " + maxOption + ".\n");
            int input = scanner.nextInt();
            if (input > minOption && input < maxOption) {
                validInput = true;
            }
        } while (!validInput);
    }

}
