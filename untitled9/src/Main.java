//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        User user1 = new User(1,"xyz","9876543210","3rd cross,4th main,xyz city ,abc - 576834");

        Items items1 = new Items(10,"Bread",30);
        Items items2= new Items(13,"tablet-x",56);

        Bill bill = new Bill(101,user1,items1,2);
        Bill bill1 = new Bill(102,user1,items2,1);

        System.out.println(bill.getBId() +" "+ items1.getName() +" "+ bill.amount());
        System.out.println(bill.getBId() +" "+ items2.getName() +" "+ bill1.amount());

        int totalPrice = bill.amount() + bill1.amount();
        System.out.println("Total Amount is : "+totalPrice);
    }
}