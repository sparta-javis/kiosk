//package team.kiosk;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//class ShopContext {
//    private Map<String, List<Menu>> menus;
//    private Map<String, List<Item>> menuItems;
//    private List<String> soldItems;
//    private List<String> waitOrders;
//    private List<String> completeOrders;
//
//    public ShopContext() {
//        menus = new HashMap<>();
//        menuItems = new HashMap<>();
//        soldItems = new ArrayList<>();
//        waitOrders = new ArrayList<>();
//        completeOrders = new ArrayList<>();
//
//        initializeMenuItems();
//    }
//
//    private void initializeMenuItems() {
//        List<Menu> mainMenus = new ArrayList<>();
//        mainMenus.add(new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거", "123"));
//        mainMenus.add(new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림", "frozen custard"));
//        mainMenus.add(new Menu("Drinks", "매장에서 직접 만드는 음료","drinks"));
//        mainMenus.add(new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주","beer"));
//
//
//        List<Menu> orderMenus = new ArrayList<>();
//        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다.", "order"));
//        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다.", "cancel"));
//
//        menus.put("Main", mainMenus);
//        menus.put("Order", orderMenus);
//
//        List<Item> burgersMenus = new ArrayList<>();
//        burgersMenus.add(new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거","burger1"));
//        burgersMenus.add(new Item("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거","burger2"));
//        burgersMenus.add(new Item("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", "burger3"));
//        burgersMenus.add(new Item("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","burger4"));
//        burgersMenus.add(new Item("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거","burger5"));
//
//        List<Item> frozenCustardMenu = new ArrayList<>();
//        frozenCustardMenu.add(new Item("Shakes", 1.4, "바닐라,초콜렛,스트로베리맛", "frozen custard1"));
//        frozenCustardMenu.add(new Item("Shake of the week", 1.0, "특별한 커스터드 플레이버", "frozen custard2"));
//        frozenCustardMenu.add(new Item("Red Bean Shake", 1.6, "신선한 커스터드와 우유,레드빈이 블렌딩", "frozen custard3"));
//        frozenCustardMenu.add(new Item("Floats", 2.1, "루트 비어,퍼플 카우,크림시클", "frozen custard4"));
//
//        List<Item> drinksMenu = new ArrayList<>();
//        drinksMenu.add(new Item("Coke", 1.0, "코카콜라","drinks1"));
//        drinksMenu.add(new Item("Cider", 1.0, "칠성사이다","drinks2"));
//
//        List<Item> beerMenu = new ArrayList<>();
//        beerMenu.add(new Item("ShackMeister Ale", 3.0, "브루클린 브루어리에서 특별히 양조한 에일맥주","beer1"));
//        beerMenu.add(new Item("Magpie Brewing Co", 4.0, "Pale Ale, Draft 맥주","beer2"));
//
//
//        menuItems.put("Burgers", burgersMenus);
//        menuItems.put("Frozen Custard", frozenCustardMenu);
//        menuItems.put("Drinks", drinksMenu);
//        menuItems.put("Beer", beerMenu);
//    }
//
//    public List<Menu> getMenus(String key) {
//        return menus.get(key);
//    }
//
//    public List<Item> getMenuItems(String key) {
//        return menuItems.get(key);
//    }
//
//    public List<String> getSoldItems() { return soldItems; }
//
//    public List<String> getWaitOrders() {
//        return waitOrders;
//    }
//
//    public void processSoldItems() {
//        // soldItems 리스트 가져오기
//        List<String> soldItems = getSoldItems();
//
//        // waitOrders 리스트에 soldItems의 요소들 추가
//        waitOrders.addAll(soldItems);
//    }
//
//
//    public void displayCompleteOrder() {
//        List<String> completeOrders = getCompleteOrders();
//
//        // createdData 최신순으로 정렬
//        Collections.sort(completeOrders, Comparator.comparing(String::toString).reversed());
//
//        // 최신순으로 3개의 요소 출력
//        int count = Math.min(completeOrders.size(), 3);
//        for (int i = 0; i < count; i++) {
//            String order = completeOrders.get(i);
//            System.out.println(order);
//        }
//
//
//    }
//
//    public void displayWaitOrder() {
//        List<String> waitOrders = getWaitOrders();
//
//        for (String order : waitOrders) {
//            System.out.println(order);
//        }
//    }
//
//    public List<String> getCompleteOrders() {
//        return completeOrders;
//    }
//
//    public void addMenuItemsInput() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("새로운 메뉴를 입력하세요.");
//        System.out.print("이름: ");
//        String name = scanner.nextLine();
//        System.out.println("가격: ");
//        Double price = scanner.nextDouble();
//        scanner.nextLine();
//        System.out.print("설명: ");
//        String description = scanner.nextLine();
//        System.out.print("id: ");
//        String id = scanner.nextLine();
//
//        Item item = new Item(name, price, description, id);
//        List<Item> itemList = menuItems.get(id);
//        itemList.add(item);
//        System.out.println("상품이 추가되었습니다.");
//    }
//
//    public void deleteMenuItemsInput() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("메뉴 id를 입력하세요.");
//        String id = scanner.nextLine();
//
//        List<Item> itemList = menuItems.get(id);
//        Item itemToRemove = null;
//        for (Item item : itemList) {
//            if (item.getId().equals(id)) {
//                itemToRemove = item;
//                break;
//            }
//        }
//
//        if (itemToRemove != null) {
//            itemList.remove(itemToRemove);
//            System.out.println("상품이 삭제되었습니다.");
//        } else {
//            System.out.println("없는 상품입니다.");
//        }
//    }
//
//
//
//    public void waitToComplete() {
//        completeOrders.addAll(waitOrders);
//        completeOrders.add(getCurrentTimestamp());
//    }
//
//    private String getCurrentTimestamp() {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
//        return now.format(formatter);
//    }
//}
