package team.kiosk;

public class Item extends Menu {

    Double price;

    Item(String name, Double price, String description, String id) {
        super(name, description, id);
        this.price = price;

    }
}
