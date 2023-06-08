package team.kiosk;

public class Item extends Menu {

    double price;

    Item(String name, double price, String description, String id) {
        super(name, description, id);
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
