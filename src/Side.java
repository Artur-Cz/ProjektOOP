public class Side {

    private String type;
    private double price;

    public Side() {
    }

    public Side(String type) {
        this.type = type;
        switch (type.toLowerCase()) {
            case "apple":
                this.price = 1.0;
                break;

            case "fries":
                this.price = 2.0;
                break;

            case "nuggets":
                this.price = 2.5;
                break;

            default:
                this.price = 0.0;
                break;
        }
    }

    public void setPrice(String type) {
        switch (type.toLowerCase()) {
            case "apple":
                this.price = 1.0;
                break;

            case "fries":
                this.price = 2.0;
                break;

            case "nuggets":
                this.price = 2.5;
                break;

            default:
                this.price = 0.0;
                break;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
