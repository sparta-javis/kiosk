package Project01;

import java.util.Scanner;

public class Product1 {
    public void processChoice(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("디저트 가게에 오신 것을 환영합니다!");
                System.out.println("아래 상품 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

                System.out.println("[ Bingsu MENU ]");
                System.out.println("1. Red Bean Bingsu     | W 7.0 | 팥 앙금과 연유가 뿌려진 빙수입니다.");
                System.out.println("2. Strawberry Bingsu   | W 8.5 | 달콤한 딸기가 들어간 빙수입니다.");
                System.out.println("3. Chocolate Bingsu    | W 9.0 | 다크 초코가 들어간 빙수입니다.");
                System.out.println("4. Matcha Bingsu       | W 9.0 | 진한 그린티 맛이 나는 빙수입니다.");
                System.out.println("5. Coffee Bingsu       | W 8.0 | 진한 커피 맛이 나는 빙수입니다.");
                break;
        }
    }
}
