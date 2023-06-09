package team.kiosk;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    int orderNumber;
    String cartString;
    double totalPrice;
    String message;
    Timestamp createdData;
    Timestamp completedData;


    public Order(int orderNumber, String cartString, double totalPrice, String message, Timestamp createdData) {
        this.orderNumber = orderNumber;
        this.cartString = cartString;
        this.totalPrice = totalPrice;
        this.message = message;
        this.createdData = createdData;

    }

    public void markAsComplete(Timestamp completedData) {
        this.completedData = completedData;
    }

    public String toString() {
        String basicInfo = "주문 번호: " + orderNumber + "\n"
                + "주문 내역: " + cartString
                + "총 가격: W " + totalPrice + "\n"
                + "메시지: " + message + "\n"
                + "주문 생성일시: " + createdData;
        if (completedData != null) {
            return basicInfo + "\n주문 완료일시: " + completedData;
        } else {
            return basicInfo + "\n주문 완료일시: N/A";
        }
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public Timestamp getCompletedData() {
        return completedData;
    }

}