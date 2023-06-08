//package team.kiosk;
//
//import java.time.format.DateTimeFormatter;
//import java.time.LocalDateTime;
//import java.util.*;
//
//class CustomerContext {
//
//    private List<Item> cart;
//    private List<String> soldItems;
//    private double totalPrice;
//    private int orderNumber;
//    private String message;
//
//    public CustomerContext() {
//
//        cart = new ArrayList<>();
//        soldItems = new ArrayList<>();
//        totalPrice = 0.0;
//        orderNumber = 0;
//
//    }
//
//    public void addToCart(Item menuItem) {
//        cart.add(menuItem);
//        totalPrice += menuItem.getPrice();
//    }
//
//    public void displayCart() {
//        for (Item item : cart) {
//            System.out.println(item.name + "   | " + item.price + " | " + item.description);
//        }
//    }
//
//    public String getTotalPrice() {
//        return String.valueOf(totalPrice);
//    }
//
//    public int generateOrderNumber() {
//        orderNumber++;
//        return orderNumber;
//    }
//
//    public void resetCart() {
//        cart.clear();
//        totalPrice = 0.0;
//    }
//
//    public void addToSoldItems() {
//        soldItems.add(String.valueOf(orderNumber));
//
//        String cartString = cart.toString();
//        soldItems.add(cartString);
//
//        String totalPriceString = getTotalPrice();
//        soldItems.add(totalPriceString);
//        soldItems.add(message);
//        soldItems.add(getISO8601DateTime());
//    }
//
//    private static String getISO8601DateTime() {
//        java.util.Date now = new java.util.Date();
//        return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(now);
//    }
//
//    public void setMessage(String message) { // 추가: message 설정 메소드
//        this.message = message;
//    }
//
//    public List<String> getSoldItems() {
//        return soldItems;
//    }
//}
