import java.time.LocalDateTime;     //used for getting the current time.
import java.time.format.DateTimeFormatter;      //used for formatting the current date time.

public class Main {
    public static void main(String[] args){

        User user1 = new User(1,"xyz","9876543210","3rd cross,4th main,xyz city ,abc - 576834");  //user details.

        Items[] items = {
                new Items(10,"bread",30,"food",2),
                new Items(13,"tablet-x",56,"med",3),
                new Items(20,"Soap",24,"others",1)
        };

        Bill bill = new Bill(101,user1,items);           //bill for items.


        LocalDateTime now = LocalDateTime.now();    //generate the current date time.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'hh:mm:ssa");
        String formatted = now.format(formatter);       //format the current date time as dd-MM-yyyy  hh:mm:ss AM/PM.

        System.out.println("                         Bill                  ");
        System.out.println("Time: "+formatted+"    Customer Name:"+user1.getUserName());//print the date time and username.
        System.out.println("Bill ID: "+bill.getBId()+"                  Contact No:"+user1.getPhNumber());   //print user contact number.
        System.out.println("Name     price   Quantity   Amount(inc tax)");        //bill details
        for (Items item: items) {
            System.out.println(item.name + "     " +
                    item.price + "        " +
                    item.quantity + "         " +
                    item.tax());
        }


        double totalPrice = items[0].tax() + items[1].tax()+items[2].tax();    //calculate the total billing amount.
        System.out.println("Total Amount is :          "+totalPrice);      //print the total billing amount.
    }
}