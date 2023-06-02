package Project01;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product1 product1 = new Product1();
        Purchase1 purchase1 = new Purchase1();
        Order1 order1 = new Order1();

        System.out.println("디저트 가게에 오신 것을 환영합니다!");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println("[ DESSERT MENU ]");
        System.out.println("1. Bingsu     | 상큼하고 시원한 빙수");
        System.out.println("2. Ice Cream  | 부드럽고 진한 아이스크림");
        System.out.println("3. Waffle     | 폭신폭식한 와플");
        System.out.println("4. Croissants | 바삭바삭한 크로와상");
        System.out.println("5. Croffle    | 와플 + 크로와상");

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order      | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel     | 진행중인 주문을 취소합니다.");

        int choice = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            if (choice == 6) {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인        2. 취소");
                System.out.print("선택: ");
                int cancelChoice = scanner.nextInt();
                scanner.nextLine();

                if (cancelChoice == 1) {
                    System.out.println("주문이 취소되었습니다.");
                    main(args);
                    return;
                }
            }

            if (choice == 5) {
                order1.main(args);
                break;
            } else {
                product1.processChoice(choice);
                System.out.print("선택: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }
}