import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Items {
    int iId;
    String name;
    int price;
    String type;
    int quantity;

    public Items(int iId, String name, int price,String type,int quantity) {
        this.iId = iId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;

    }
    public int amount(){        //calculate the amount of item WRT purchased quantity
        int z = quantity * price;
        return z;
    }

    public double tax(){
        if (type == "med"){
            double t= (amount()*0.05)+amount();
            return t;
        }
        else if (type == "food") {
            double t= (amount()*0.1)+amount();
            return t;
        }
        else {
            double t= (amount()*0.15)+amount();
            return t;

        }
    }
}
