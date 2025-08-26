package com.billing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bill {
    private final int bId;
    private final User user;
    private final List<Item> itemsList = new ArrayList<>();

    public Bill(int bId, User user) {
        this.bId = bId;
        this.user = user;
    }

    public void addItem(Item item) {
        this.itemsList.add(item);
    }

    public int getBillId() { return bId; }
    public User getUser() { return user; }
    public List<Item> getItemsList() { return Collections.unmodifiableList(itemsList); }

    public double getSubtotal() {
        return itemsList.stream().mapToDouble(Item::getLineSubtotal).sum();
    }

    public double getTaxTotal() {
        return itemsList.stream().mapToDouble(Item::getTax).sum();
    }

    public double getGrandTotal() {
        return getSubtotal() + getTaxTotal();
    }
}
