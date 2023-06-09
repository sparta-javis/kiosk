package team.kiosk;

class Menu {
    String name;
    String description;
    String id;

    Menu(String name, String description, String id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() { return id; }
}

