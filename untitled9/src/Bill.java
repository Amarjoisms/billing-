import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill {
    int bId;
    User user;
    Items items;
    int quantity;
//    int amount;
 //   int totalPrice;

    public Bill(int bId, User user, Items items, int quantity) {
        this.bId = bId;
        this.user = user;
        this.items = items;
        this.quantity = quantity;
//        this.amount = amount;
//        this.totalPrice = totalPrice;
    }

    public int amount(){
        int z = quantity * items.getPrice();
        return z;
    }


}
