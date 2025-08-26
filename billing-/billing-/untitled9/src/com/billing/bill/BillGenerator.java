package com.billing.bill;

import com.billing.model.Bill;
import com.billing.model.Item;
import com.billing.model.User;
import com.billing.tax.TaxCalculator;
import com.billing.tax.TaxCalculatorFactory;
import com.billing.util.Printable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BillGenerator implements Printable {
    private final Bill bill;
    private final List<Item> itemList;

    public BillGenerator(Bill bill) {
        this.bill = bill;
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
        this.bill.addItem(item);
    }

    public Bill calculate(){
        TaxCalculatorFactory factory = new TaxCalculatorFactory();
        for (Item item: itemList){
            TaxCalculator calculator = factory.taxCalculator(item.getItemType());
            double amount = item.getQuantity() * item.getPrice();
            item.withTax(calculator.calculateTax(amount));
        }
        return bill;
    }

    @Override
    public void print() {
        User user = bill.getUser();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("========== INVOICE ==========");
        System.out.printf("Bill ID : %d%n", bill.getBillId());
        System.out.printf("User    : %s (ID: %d)%n", user.getUserName(), user.getUId());
        user.getAddress().ifPresent(a -> System.out.printf("Address : %s%n", a));
        System.out.printf("Phone   : %s%n", user.getPhNumber());
        System.out.printf("Date    : %s%n", LocalDateTime.now().format(fmt));
        System.out.println("-----------------------------");
        System.out.printf("%-3s %-18s %6s %8s %8s %8s%n", "Qty", "Item", "Type", "Price", "Tax", "Total");
        System.out.println("-----------------------------");
        bill.getItemsList().forEach(i -> {
            System.out.printf("%-3d %-18s %6s %8.2f %8.2f %8.2f%n",
                    i.getQuantity(),
                    i.getItemName(),
                    i.getItemType().name(),
                    i.getLineSubtotal(),
                    i.getTax(),
                    i.getLineTotal());
        });
        System.out.println("-----------------------------");
        System.out.printf("%-30s %8.2f%n", "Subtotal:", bill.getSubtotal());
        System.out.printf("%-30s %8.2f%n", "Tax total:", bill.getTaxTotal());
        System.out.printf("%-30s %8.2f%n", "Grand total:", bill.getGrandTotal());
        System.out.println("=============================");
    }
}
