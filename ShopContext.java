package team.kiosk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopContext {
    private List<String> waitOrders;

    public ShopContext() {
        waitOrders = new ArrayList<>();
    }

    public List<String> getWaitOrders() {
        return waitOrders;
    }

    public void addWaitOrder(int waitNumber, List<String> orderItems, double totalPrice, String request, LocalDateTime orderDateTime) {
        String waitOrderString = "대기 번호: " + waitNumber + ""
                + "주문 상품 목록: " + String.join(", ", orderItems) + ""
                + "주문 총 가격: " + totalPrice + ""
                + "요청 사항: " + request + ""
                + "주문 일시: " + orderDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        waitOrders.add(waitOrderString);
    }

    public void completeWaitOrder(int index) {
        if (index >= 0 && index < waitOrders.size()) {
            waitOrders.remove(index);
        }
    }

    // 대기 주문을 완료로 변경하는 메서드
    public void waitToComplete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("대기주문을 완료로 바꾸시겠습니까?");
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("주문이 완료되었습니다.");
        } else if (input == 2) {
            System.out.println("대기 중 주문입니다.");
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }
}
