package team.kiosk;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order extends Item {
    int orderNumber;
    List<Item> cart;
    double totalPrice;
    String message;
    Timestamp createdData;


    public Order(int orderNumber, List<Item> cartItems, double totalPrice, String message, Timestamp createdData) {
        super(cartItems.get(0).getName(), cartItems.get(0).getPrice(), cartItems.get(0).getDescription(), cartItems.get(0).getId());
        this.orderNumber = orderNumber;
        this.cart = cartItems;
        this.totalPrice = totalPrice;
        this.message = message;
        this.createdData = createdData;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public List<Item> getCartItems() {
//        return cartItems;
//    }
//
//    public void setCartItems(List<Item> cartItems) {
//        this.cartItems = cartItems;
//    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Timestamp createdData) {
        this.createdData = createdData;
    }

}
