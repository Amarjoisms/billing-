import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    int uId;
    String userName;
    String address;
    String phNumber;

    public User(int uId, String userName, String phNumber, String address) {
        this.uId = uId;
        this.userName = userName;
        this.phNumber = phNumber;
        this.address = address;
    }


}
