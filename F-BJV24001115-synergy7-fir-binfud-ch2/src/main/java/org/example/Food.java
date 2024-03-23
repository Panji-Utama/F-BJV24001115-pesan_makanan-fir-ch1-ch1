package org.example;

public class Food {
    private final String name;
    private final int price;
    private final int qty;
    private final int totalPrice;

    public Food(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.totalPrice = price * qty;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
