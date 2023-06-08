package team.kiosk;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderNumber;
    String cartString;
    double totalPrice;
    String message;
    Timestamp createdData;


    public Order(int orderNumber, String cartString, double totalPrice, String message, Timestamp createdData) {
        this.orderNumber = orderNumber;
        this.cartString = cartString;
        this.totalPrice = totalPrice;
        this.message = message;
        this.createdData = createdData;

    }

    @Override
    public String toString() {
        return "주문 번호: " + orderNumber + "\n"
                + "카트 내용물: " + cartString + "\n"
                + "총 가격: " + totalPrice + "\n"
                + "메시지: " + message + "\n"
                + "주문 생성일시: " + createdData;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

}