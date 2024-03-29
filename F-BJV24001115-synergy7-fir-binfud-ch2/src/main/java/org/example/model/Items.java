package org.example.model;

public abstract class Items {
    protected String name;
    protected int price;
    protected int qty;

    protected Items(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getDescription() {
        return String.format("%s at %d each.", name, price);
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
        return price * qty;
    }
}
