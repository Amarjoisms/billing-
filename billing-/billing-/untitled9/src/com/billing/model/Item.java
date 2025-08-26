package com.billing.model;

public class Item {
    private final int itemId;
    private final String itemName;
    private final double price;     // unit price
    private final ItemType itemType;
    private final int quantity;
    private double tax;             // computed tax for the line

    public Item(int itemId,
                String itemName,
                double price,
                ItemType type,
                int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.itemType = type;
        this.quantity = quantity;
        this.tax = 0.0;
    }

    /** Fluent setter for tax amount for this line item. */
    public Item withTax(double tax) {
        this.tax = tax;
        return this;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public ItemType getItemType() { return itemType; }
    public int getQuantity() { return quantity; }
    public double getTax() { return tax; }

    public double getLineSubtotal() {
        return price * quantity;
    }

    public double getLineTotal() {
        return getLineSubtotal() + tax;
    }
}
