package team.kiosk;

import java.util.*;

class ShopContext {
    private Map<String, List<Menu>> menus;
    private Map<String, List<Item>> menuItems;
    public List<Item> soldItems;
    public List<String[]> waitOrders;
    //승철 수정
    public List<String[]> completeOrders;
    //승철 수정 -> completeOrders 는 결국 waitOrders에서 완료처리한 데이터들을 담는 리스트 ㅇㅇ

    public ShopContext() {
        menus = new HashMap<>();
        menuItems = new HashMap<>();
        soldItems = new ArrayList<>();
        waitOrders = new ArrayList<>();
        completeOrders = new ArrayList<>();

        initializeMenuItems();
    }

    private void initializeMenuItems() {ㅇ
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거", "123"));
//        mainMenus.add(new Menu("Forzen Custard", "매장에서 신선하게 만드는 아이스크림"));
//        mainMenus.add(new Menu("Drinks", "매장에서 직접 만드는 음료"));
//        mainMenus.add(new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));

        List<Menu> orderMenus = new ArrayList<>();
//        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
//        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenus);

        List<Item> burgersMenus = new ArrayList<>();
//        burgersMenus.add(new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
//        burgersMenus.add(new Item("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
//        burgersMenus.add(new Item("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
//        burgersMenus.add(new Item("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
//        burgersMenus.add(new Item("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<Item> frozenCustardMenu = new ArrayList<>();
//        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 1", 1.4, "Frozen Custard Menu Item 1 설명"));
//        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 2", 1.0, "Frozen Custard Menu Item 2 설명"));
//        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 3", 1.6, "Frozen Custard Menu Item 3 설명"));
//        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 4", 2.1, "Frozen Custard Menu Item 4 설명"));

        List<Item> drinksMenu = new ArrayList<>();
//        drinksMenu.add(new Item("Drinks Menu Item 1", 1.0, "Drinks Menu Item 1 설명"));
//        drinksMenu.add(new Item("Drinks Menu Item 2", 1.0, "Drinks Menu Item 2 설명"));

        List<Item> beerMenu = new ArrayList<>();
//        beerMenu.add(new Item("Beer Menu Item 1", 3.0, "Beer Menu Item 1 설명"));
//        beerMenu.add(new Item("Beer Menu Item 2", 4.0, "Beer Menu Item 2 설명"));

        menuItems.put("Burgers", burgersMenus);
        menuItems.put("Frozen Custard", frozenCustardMenu);
        menuItems.put("Drinks", drinksMenu);
        menuItems.put("Beer", beerMenu);

        List<String[]> waitOrders = new ArrayList<>();
        List<String[]> completeOrders = new ArrayList<>();
    }

    public List<Menu> getMenus(String key) {
        return menus.get(key);
    }

    public List<Item> getMenuItems(String key) {
        return menuItems.get(key);
    }


    public void displayWaitOrder() {
        for (String order : waitOrders ) {
            System.out.println(item.name + "   | " + item.price + " | " + item.description);
        }
    }


    public List<String[]> getWaitOrders() {
        return waitOrders;
    }

//승철 수저사항 입니다 완료 주문 목록 처리
    public void displayCompleteOrder(List<String[]> completeOrders) {
        System.out.println("[완료 주문 목록]");

        for (String[] order : completeOrders) {
            System.out.println("대기번호: " + order[0] + " | 상품이름: " + order[1]+ " | 총가격: " + order[2]+
                    " | 주문일자: " + order[3] + " | 요청사항: " + order[4] + " | 완료일자: " + order[5]);
        }
    }
    //completeOrders에 담는 행위 자체는 - > 대기목록 주문처리에서 처리해야함
    //즉, displayCompleteOrders() -> 는 담겨있는 데이터를 가져와서 프린트 (문제는 완료주문일시)
    //수정사항 - 승철
    public List<String[]> getCompleteOrders() {

        return completeOrders;
    }
    //수정사항 - 승철
    public void addMenuItemsInput() {

    }

    public static void deleteMenuItemsInput() {

    }

}


