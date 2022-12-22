import java.util.Scanner;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("deluxe", 7.50, 6);
    }

    @Override
    protected void getExtraToppings() {
        StringBuilder toppingName = new StringBuilder();
        int counter = 0;
        boolean validInput = false;
        System.out.println("Please choose one of the following toppings:\n\n1. Extra cheese;\n2. Extra onion;\n" +
                "3. Extra pickle;\n4. Extra tomato;\n5. Extra bacon;\n6. Extra lettuce;\n7. Extra egg;\n8. No more toppings.");
        while (counter < 6) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please choose a topping.\n");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    toppingName.append("extra cheese\n");
                    counter++;
                    break;

                case 5:
                    toppingName.append("extra bacon\n");
                    counter++;
                    break;

                case 7:
                    toppingName.append("extra egg\n");
                    counter++;
                    break;

                case 2:
                    toppingName.append("extra onion\n");
                    counter++;
                    break;


                case 3:
                    toppingName.append("extra pickle\n");
                    counter++;
                    break;

                case 4:
                    toppingName.append("extra tomato\n");
                    counter++;
                    break;

                case 6:
                    toppingName.append("extra lettuce\n");
                    counter++;
                    break;

                case 8:
                    System.out.println("All toppings have been chosen.");
                    counter = 6;
                    break;

                default:
                    do {
                        System.out.println("Incorrect option. Please choose option from 1 to 7.\n");
                        input = scanner.nextInt();
                        if (input > 0 && input < 8) {
                            validInput = true;
                        }
                    } while (!validInput);
            }
        }

        System.out.println("Thank you for choosing. The toppings you have chosen are:\n\n" + toppingName);
    }
}
