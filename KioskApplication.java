package team.kiosk;

import java.util.*;

public class KioskApplication {
    private static CustomerContext customerContext;
    private static ShopContext shopContext;


    public static void main(String[] args) {
        customerContext = new CustomerContext();
        shopContext = new ShopContext();
        displayMainMenu();
        displayOrderNow();
        handleMainMenuInput();


    }

    private static void displayMainMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");

        System.out.println("[ SHAKESHACK MENU ]");
        List<Menu> mainMenus = shopContext.getMenus("Main");
        int nextNum = printMenu(mainMenus, 1);

        System.out.println("[ ORDER MENU ]");
        List<Menu> orderMenus = shopContext.getMenus("Order");
        printMenu(orderMenus, nextNum);
    }

    private static int printMenu(List<Menu> menus, int num) {
        for (int i=0; i<menus.size(); i++) {
            System.out.println(num++ + ". " + menus.get(i).name + "   | " + menus.get(i).description);
        }
        return num;
    }

    private static void displayOrderNow() {
        System.out.println("[ 주문 현황 ]");
        List<Item> completeOrders = shopContext.getCompleteOrders();
        List<Item> waitOrders = shopContext.getWaitOrders();
        printMenuItems(completeOrders);
        printMenuItems(waitOrders);
    }

    private static void handleMainMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                displayBurgersMenu();
                break;
            case 2:
                displayFrozenCustardMenu();
                break;
            case 3:
                displayDrinksMenu();
                break;
            case 4:
                displayBeerMenu();
                break;
            case 5:
                displayOrderMenu();
                break;
            case 6:
                handleCancelMenuInput();
                break;
            case 0:
                displayAdministrationMenu();
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                handleMainMenuInput();
                break;
        }
    }

    private static void displayBurgersMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Burgers MENU ]");
        List<Item> burgerItems = shopContext.getMenuItems("Burgers");
        printMenuItems(burgerItems);

        handleMenuItemInput(burgerItems);
    }

    private static void handleMenuItemInput(List<Item> items) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input >= 1 && input <= items.size()) {
            Item selectedItem = items.get(input);
            displayConfirmation(selectedItem);
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleMenuItemInput(items);
        }
    }

    private static void printMenuItems(List<Item> items) {
        for (int i=0; i<items.size(); i++) {
            int num = i + 1;
            System.out.println(num + ". " + items.get(i).name + "   | " + items.get(i).price + " | " + items.get(i).description);
        }
    }
    private static void displayFrozenCustardMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Frozen Custard MENU ]");
        List<Item> frozenCustardItems = shopContext.getMenuItems("Frozen Custard");
        printMenuItems(frozenCustardItems);

        handleMenuItemInput(frozenCustardItems);
    }

    private static void displayDrinksMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Drinks MENU ]");
        List<Item> drinkItems = shopContext.getMenuItems("Drinks");
        printMenuItems(drinkItems);

        handleMenuItemInput(drinkItems);
    }

    private static void displayBeerMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Beer MENU ]");
        List<Item> beerItems = shopContext.getMenuItems("Beer");
        printMenuItems(beerItems);

        handleMenuItemInput(beerItems);
    }

    private static void displayConfirmation(Item menuItem) {
        System.out.println(menuItem.name + "   | " + menuItem.price + " | " + menuItem.description);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        handleConfirmationInput(menuItem);
    }

    private static void handleConfirmationInput(Item menuItem) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            customerContext.addToCart(menuItem);
            System.out.println("장바구니에 추가되었습니다.");
            displayMainMenu();
        } else if (input == 2) {
            displayMainMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleConfirmationInput(menuItem);
        }
    }

    private static void displayOrderMenu() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        customerContext.displayCart();

        System.out.println("[ Total ]");
        System.out.println("W " + customerContext.getTotalPrice() + "\n");

        System.out.println("1. 주문      2. 메뉴판");

        handleOrderMenuInput();
    }

    private static void handleOrderMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            displayOrderComplete();
            customerContext.addToSoldItems();

        } else if (input == 2) {
            displayMainMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleOrderMenuInput();
        }
    }

    private static void displayOrderComplete() {
        int orderNumber = customerContext.generateOrderNumber();
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");

        resetCartAndDisplayMainMenu();
    }

    private static void resetCartAndDisplayMainMenu() {
        customerContext.resetCart();
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        displayMainMenu();
    }

    private static void handleCancelMenuInput() {
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        handleCancelConfirmationInput();
    }

    private static void handleCancelConfirmationInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            customerContext.resetCart();
            System.out.println("주문이 취소되었습니다.");
            displayMainMenu();
        } else if (input == 2) {
            displayMainMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleCancelConfirmationInput();
        }
    }

    private static void displayAdministrationMenu() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("대기주문 목록");
                shopContext.displayWaitOrder();
                handleOrderInput();
                break;
            case 2:
                System.out.println("완료주문 목록");
                shopContext.displayCompleteOrder();
                break;
            case 3:
                System.out.println("상품 생성");
                shopContext.addMenuItemsInput();
                break;
            case 4:
                System.out.println("상품 삭제");
                shopContext.deleteMenuItemsInput();
                break;
        }
    }

    public static void handleOrderInput() {
//  추가해 놓은 대기주문목록 --> 완료주문목록 넣는 함수입니다 아래 슬랙에 적어놓은 시간 데이터 넣는 클래스 추가 필요
//        List<String[]> completeOrders = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("대기번호를 입력하세요: ");
//        String inputOrderNumber = scanner.nextLine();
//
//        for (String[] order : waitOrders) {
//            String orderNumber = order[0];
//            if (orderNumber.equals(inputOrderNumber)) {
//                // 대기번호와 함께 날짜와 시간(ISO 8601 형식)을 completeOrders 배열에 추가
//                String[] completeOrder = new String[order.length + 1];
//                System.arraycopy(order, 0, completeOrder, 0, order.length); // 이전 데이터 복사
//                completeOrder[order.length] = getISO8601DateTime(); // 현재 시간 추가
//                completeOrders.add(completeOrder);
//            }
//        }

    }

    private static void addNewItem(String menuName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("상품 이름");
        String itemName = scanner.nextLine();

        System.out.println("상품 가격");
        Double price = scanner.nextDouble();

        System.out.println("상품 설명");
        String description = scanner.nextLine();

        System.out.println("상품 Id");
        String Id = scanner.nextLine();

        // 중복 ID 체크
        if (ShopContext.menuItems.containsKey(Id)) {
            System.out.println("이미 해당 ID로 등록된 메뉴가 있습니다.");
            return; // 중복 ID가 있으므로 추가 작업을 중단하고 메서드를 종료합니다.
        }

        Item newItem = new Item(itemName,price,description,Id);

         shopContext.addMenuItemsInput(menuName, newItem);
         // shopContext 소문자로 써야 하는 이유
        // ShopContext. 으로 하면 static 메서드로 사용하기 때문
        // 클래스 , 메소드 , 생성자 , 정적메소드(static) 개념 파악 필요

        // hash map 은 같은 id 값이 있을 때 하나로 처리한다.


        // 왜 오류나는지? (오류대로 ShopContext.addMenuItemsInput 를 static 으로 바꾸면 안된다.
        // static -> 클래스를 통해 인스턴스를 생성할 필요 없이, 클래스의 속성 또는 메서드를 사용하고자
        // 한다면 쓰는 키워드. 우리는 addMenuItemsInput을 클래스를 통해 인스턴스를 생성하고자 하기때명
        displayAdministrationMenu();
    }
}
