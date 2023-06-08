package team.kiosk;

import java.util.*;

class ShopContext {
    private Map<String, List<Menu>> menus;
    private Map<String, List<Item>> menuItems;
    public List<Item> soldItems;
    public List<Item> waitOrders;
    public List<Item> completeOrders;

    public ShopContext() {
        menus = new HashMap<>();
        menuItems = new HashMap<>();
        soldItems = new ArrayList<>();
        waitOrders = new ArrayList<>();
        completeOrders = new ArrayList<>();

        initializeMenuItems();
    }

    private void initializeMenuItems() {
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거", "burger"));
        mainMenus.add(new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림", "frozen custard"));
        mainMenus.add(new Menu("Drinks", "매장에서 직접 만드는 음료","drinks"));
        mainMenus.add(new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주","beer"));

        List<Menu> orderMenus = new ArrayList<>();
//        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
//        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenus);

        List<Item> burgersMenus = new ArrayList<>();
        burgersMenus.add(new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거","burger1"));
        burgersMenus.add(new Item("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거","burger2"));
        burgersMenus.add(new Item("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", "burger3"));
        burgersMenus.add(new Item("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","burger4"));
        burgersMenus.add(new Item("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거","burger5"));

        // 프로즌 커스타드 id 띄어쓰기 주의
        List<Item> frozenCustardMenu = new ArrayList<>();
        frozenCustardMenu.add(new Item("Shakes", 1.4, "바닐라,초콜렛,스트로베리맛", "frozen custard1"));
        frozenCustardMenu.add(new Item("Shake of the week", 1.0, "특별한 커스터드 플레이버", "frozen custard2"));
        frozenCustardMenu.add(new Item("Red Bean Shake", 1.6, "신선한 커스터드와 우유,레드빈이 블렌딩", "frozen custard3"));
        frozenCustardMenu.add(new Item("Floats", 2.1, "루트 비어,퍼플 카우,크림시클", "frozen custard4"));

        List<Item> drinksMenu = new ArrayList<>();
        drinksMenu.add(new Item("Coke", 1.0, "코카콜라","drinks1"));
        drinksMenu.add(new Item("Cider", 1.0, "칠성사이다","drinks2"));

        List<Item> beerMenu = new ArrayList<>();
        beerMenu.add(new Item("ShackMeister Ale", 3.0, "브루클린 브루어리에서 특별히 양조한 에일맥주","beer1"));
        beerMenu.add(new Item("Magpie Brewing Co", 4.0, "Pale Ale, Draft 맥주","beer2"));

        menuItems.put("Burgers", burgersMenus);
        menuItems.put("Frozen Custard", frozenCustardMenu);
        menuItems.put("Drinks", drinksMenu);
        menuItems.put("Beer", beerMenu);

        List<Item> waitOrders = new ArrayList<>();
        List<Item> completeOrders = new ArrayList<>();
    }

    public List<Menu> getMenus(String key) {
        return menus.get(key);
    }

    public List<Item> getMenuItems(String key) {
        return menuItems.get(key);
    }


    public void displayWaitOrder() {
        for (Item item : waitOrders ) {
            System.out.println(item.name + "   | " + item.price + " | " + item.description);
        }
    }


    public List<Item> getWaitOrders() {
        return waitOrders;
    }


    public void displayCompleteOrder() {
        List<> completeOrders = shopContext.getCompleterders();
        for (Order order : completeOrders ) {
            System.out.println(order.getItem().getName() + "   | " + item.price + " | " + item.description);
        }
    }

    public List<Item> getCompleteOrders() {
        return completeOrders;
    }

    // 상품 생성
    // 새로운 상품정보(메뉴, 이름, 설명, 가격)을 입력하여 생성할 수 있다.
    // 기존에 없는 메뉴라면 신규로 생성해준다.
    // 새로 생성된 메뉴와 상품은 각각 유일한 메뉴ID, 상품ID 식별자를 가진다.
    public void addMenuItemsInput(String menuName, Item newItem) {

        if (this.menuItems.containsKey(menuName)) {
            this.menuItems.get(menuName).add(newItem); // 리스트 아이템이 꺼내질 것
            // this(이 객체,) Shopcontext 에서 menuName에


            // List<Item> items = menuItems.get(menuName);
            // 처음에 빈리스트 생성되어 있어야함. ( New arrayList )
            // Item List 에 있는 리스트들을 menuItem 에 넣는다
            // items.add(newItem); // 상품이름
            // this.menuItems.put(menuName, items);

            // put 을 쓰는 이유? -> menuItems 의 형태가 map 이기 때문.
            // => type 별로 다뤄야 할 메서드가 다른 것.
            // type 특성 모를 때 ? -> map 요소 추가 등으로 검색해서 명령어나 메서드 알기.


            System.out.println("신규 메뉴가 등록되었습니다.");
        } else {
            System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
        }

    }

    public static void deleteMenuItemsInput() {

    }

}
