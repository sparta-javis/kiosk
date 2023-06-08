package team.kiosk;

import java.util.*;

// 명지

public class KioskApplication {

    private static MenuContext menuContext;

    private static List<Order> completeOrders = new ArrayList<>();
    private static List<Order> waitOrders = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        menuContext = new MenuContext();

        while (true) {
            displayMainMenu();
            displayOrderNow();

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
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");

        System.out.println("[ SHAKESHACK MENU ]");
        List<Menu> mainMenus = menuContext.getMenus("Main");
        int nextNum = printMenu(mainMenus, 1);

        System.out.println("[ ORDER MENU ]");
        List<Menu> orderMenus = menuContext.getMenus("Order");
        printMenu(orderMenus, nextNum);
    }

    private static int printMenu(List<Menu> menus, int num) {
        for (Menu menu : menus) {
            System.out.println(num++ + ". " + menu.getName() + "   | " + menu.getDescription());
        }
        return num;
    }

    private static void displayOrderNow() {
        System.out.println("[ 주문 현황 ]");

        if (completeOrders.isEmpty()) {
            System.out.println("완료된 주문이 없습니다.");
        } else {
            int startIndex = Math.max(0, completeOrders.size() - 3); // Calculate the starting index
            for (int i = startIndex; i < completeOrders.size(); i++) {
                Order order = completeOrders.get(i);
                System.out.println(order.toString());
            }
        }

        if(waitOrders.isEmpty()) {
            System.out.println("대기 중인 주문이 없습니다.");
        } else {
            for (Order order : waitOrders) {
                System.out.println(order.toString());
            }
        }
    }


    private static void displayBurgersMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Burgers MENU ]");
        List<Item> burgerItems = menuContext.getMenuItems("Burgers");
        printMenuItems(burgerItems);

        handleMenuItemInput(burgerItems);
    }

    private static void handleMenuItemInput(List<Item> items) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input >= 1 && input <= items.size()) {
            Item selectedItem = items.get(input-1);
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
        List<Item> frozenCustardItems = menuContext.getMenuItems("Frozen Custard");
        printMenuItems(frozenCustardItems);

        handleMenuItemInput(frozenCustardItems);
    }

    private static void displayDrinksMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Drinks MENU ]");
        List<Item> drinkItems = menuContext.getMenuItems("Drinks");
        printMenuItems(drinkItems);

        handleMenuItemInput(drinkItems);
    }

    private static void displayBeerMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ Beer MENU ]");
        List<Item> beerItems = menuContext.getMenuItems("Beer");
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
            menuContext.addToCart(menuItem);
            System.out.println("장바구니에 추가되었습니다.");

        } else if (input == 2) {
            displayMainMenu();
            displayOrderNow();

        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleConfirmationInput(menuItem);
        }
    }



    private static void displayOrderMenu() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        menuContext.displayCart();

        System.out.println("[ Total ]");
        System.out.println("W " + menuContext.getTotalPrice() + "\n");
        System.out.println("요청사항: ");
        menuContext.messageInput();

        System.out.println("1. 주문      2. 메뉴판");

        handleOrderMenuInput();
    }



    private static void handleOrderMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            displayOrderComplete();

        } else if (input == 2) {
            displayMainMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleOrderMenuInput();
        }
    }

    private static void displayOrderComplete() {

        int orderNumber = menuContext.generateOrderNumber();

        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");

        menuContext.addToWaitOrders();

        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
            menuContext.resetCart();
            System.out.println("주문이 취소되었습니다.");
            displayMainMenu();
            displayOrderNow();

        } else if (input == 2) {
            displayMainMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleCancelConfirmationInput();
        }
    }

    private static void displayAdministrationMenu() {
        System.out.println("[관리자 메뉴]");
        System.out.println("1. 대기주문 목록\n2. 완료주문 목록\n3. 상품 생성\n4. 상품 삭제");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("[ 대기주문 목록 ]");
                if(waitOrders.isEmpty()) {
                    System.out.println("대기 중인 주문이 없습니다.");
                } else {
                    for (Order order : waitOrders) {
                        System.out.println(order.toString());
                    }
                }

                System.out.println("대기주문 선택하기: ");
                int orderNumber = scanner.nextInt();
                handleOrderInput(orderNumber);

                break;
            case 2:
                System.out.println("[ 완료주문 목록 ]");
                if(waitOrders.isEmpty()) {
                    System.out.println("대기 중인 주문이 없습니다.");
                } else {
                    for (Order order : waitOrders) {
                        System.out.println(order.toString());
                    }
                }

                break;
            case 3:
                menuContext.addMenuItemsInput();

                break;
            case 4:
                menuContext.deleteMenuItemsInput();

                break;
            default:

                break;
        }
    }



    // 주문 대기 -> 완료 메서드
    public static void handleOrderInput(int orderNumber) {
        // Find the order with the given order number
        Order order = null;
        for (Order waitOrder : waitOrders) {
            if (waitOrder.getOrderNumber() == orderNumber) {
                order = waitOrder;
                break;
            }
        }

        if (order != null) {
            System.out.println("대기 주문을 완료로 변경하시겠습니까?");
            System.out.println("1. 예");
            System.out.println("2. 아니오");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if (input == 1) {
                System.out.println("주문이 완료되었습니다.");
                menuContext.waitToComplete(order);
                waitOrders.remove(order);
                completeOrders.add(order);
            } else if (input == 2) {
                System.out.println("주문을 대기 상태로 유지합니다.");
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                handleOrderInput(orderNumber);
            }
        } else {
            System.out.println("주문번호에 해당하는 주문이 존재하지 않습니다.");
        }
    }

}
