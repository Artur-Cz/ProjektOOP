public class Main {

    public static void main(String[] args) {
        Hamburger burger = new Hamburger();
        Drink drink = new Drink();
        Side side = new Side();
        Order order = new Order(burger, drink, side);

        order.orderMeal();
    }
}
