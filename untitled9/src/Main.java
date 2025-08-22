import java.time.LocalDateTime;     //used for getting the current time.
import java.time.format.DateTimeFormatter;      //used for formatting the current date time.

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        User user1 = new User(1,"xyz","9876543210","3rd cross,4th main,xyz city ,abc - 576834");  //user details.

        Items items1 = new Items(10,"Bread",30);        //purchased item1 details.
        Items items2= new Items(13,"tablet-x",56);      //purchased item2 details.

        Bill bill = new Bill(101,user1,items1,2);           //bill for item1.
        Bill bill1 = new Bill(102,user1,items2,1);          //bill for item2.


        LocalDateTime now = LocalDateTime.now();    //generate the current date time.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'hh:mm:ssa");
        String formatted = now.format(formatter);       //format the current date time as dd-MM-yyyy  hh:mm:ss AM/PM.

        System.out.println("                         Bill                  ");
        System.out.println("Time: "+formatted+"    Customer Name:"+user1.getUserName());//print the date time and username.
        System.out.println("                               Contact No:"+user1.getPhNumber());   //print user contact number.
        System.out.println("Bill ID   Items     price   Quantity   Amount");        //bill details
        System.out.println(bill.getBId() +"      "+ items1.getName() +"         "+items1.getPrice() +"      "+ bill.quantity+"         "+ bill.amount());       //item1 bill details.
        System.out.println(bill1.getBId() +"      "+ items2.getName() +"      "+items2.getPrice() +"      "+ bill1.quantity+"         "+ bill1.amount());        //item2 bill details.


        int totalPrice = bill.amount() + bill1.amount();    //calculate the total billing amount.
        System.out.println("Total Amount is :                       "+totalPrice);      //print the total billing amount.
    }
}