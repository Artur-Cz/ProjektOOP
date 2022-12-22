import java.util.Scanner;

public class Drink {

    private String type;
    private String size;
    private double price;

    public Drink() {
    }

    public Drink(String type, String size) {
        this.type = type;
        switch (size.toLowerCase()) {
            case "small":
                this.price = 2.5;
                break;

            case "medium":
                this.price = 3.4;
                break;

            case "large":
                this.price = 4.0;
                break;

            default:
                this.price = -0.0;
                break;
        }
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                this.price = 2.5;
                break;

            case "medium":
                this.price = 3.4;
                break;

            case "large":
                this.price = 4.0;
                break;

            default:
                this.price = 0.0;
                break;
        }

    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void chooseSize(String type) {
        Scanner scanner = new Scanner(System.in);
        setType(type);
        System.out.println("Please choose the preferred size:\n\n1. Small\n2. Medium\n3. Large");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                setType("small");
                break;

            case 2:
                setType("medium");
                break;

            case 3:
                setType("large");
                break;

            default:
                invalidInput(1, 3);
        }
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
