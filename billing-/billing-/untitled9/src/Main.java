import com.billing.bill.BillGenerator;
import com.billing.model.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .withUserId(1)
                .withName("Rakshith")
                .withAddress("Bengaluru")
                .withPhoneNumber("99999-00000")
                .build();

        Bill bill = new Bill(1001, user);
        BillGenerator generator = new BillGenerator(bill);
        generator.addItem(new Item(1, "Paracetamol", 50.0, ItemType.Medicine, 2));
        generator.addItem(new Item(2, "Bread", 40.0, ItemType.Food, 3));
        generator.addItem(new Item(3, "Notebook", 60.0, ItemType.Others, 1));

        generator.calculate();
        generator.print();
    }
}
