package team.kiosk;

import java.util.*;

class CustomerContext {

    private List<Item> cart;
    public static List<Item> soldItems;
    private double totalPrice;
    private int orderNumber;

    public CustomerContext() {

        cart = new ArrayList<>();
        soldItems = new ArrayList<>();
        totalPrice = 0.0;
        orderNumber = 0;

    }

    public void addToCart(Item getMenuItem) {
        cart.add(getMenuItem);
        totalPrice += getMenuItem.price;
    }

    public void displayCart() {
        for (Item item : cart) {
            System.out.println(item.name + "   | " + item.price + " | " + item.description);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int generateOrderNumber() {
        orderNumber++;
        return orderNumber;
    }

    public void resetCart() {
        cart.clear();
        totalPrice = 0.0;
    }

    public void addToSoldItems() {
        soldItems.addAll(cart);
        // 주문시간;
        // message;
    }

    public List<Item> getSoldItems() {
        return soldItems;
    }
}
