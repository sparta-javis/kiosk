package team.kiosk;
import java.time.LocalDateTime;
public class Item extends Menu {
    //승철 수정사항 - 대기번호(int) orderNumber , 요청사항 (String) 메세지 추가
    Double price;
    int orderNumber;
    String message;


//승철 수정사항 - 대기번호(int) orderNumber , 요청사항 (String) 메세지 ㅇㅇ
    Item(int orderNumber, String name, Double price, String description, String message String id) {
        super(name, description, id);
        this.orderNumber = orderNumber;
        this.price = price;
        this.message = message;
    }
//승철 수정사항 - 대기번호(int) orderNumber , 요청사항 (String) 메세지 추가