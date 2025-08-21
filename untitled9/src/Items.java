import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Items {
    int iId;
    String name;
    int price;

    public Items(int iId, String name, int price) {
        this.iId = iId;
        this.name = name;
        this.price = price;
    }
}
