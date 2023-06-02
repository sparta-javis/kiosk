package Project01;

import java.util.Scanner;

public class Purchase1 {
    public void purchaseMenu(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Coffee Bingsu       | W 8.0 | 진한 커피 맛이 나는 빙수입니다.");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("메뉴가 장바구니에 추가되었습니다.");
            Main1.main(args);
        }
    }
}
