package Project01;

import java.util.Scanner;

public class Order1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Coffee Bingsu       | W 8.0 | 진한 커피 맛이 나는 빙수입니다.");
        System.out.println("Total         | W 8.0");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 주문        2. 메뉴판");
        System.out.print("선택: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("메뉴가 장바구니에 추가되었습니다.");
            System.out.println("대기번호를 발급해드립니다.");
            System.out.println("대기번호는 1번 입니다.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main1.main(args);

        } else if (choice == 2) {
            Main1.main(args);
        }
    }
}