package org.example.model;

<<<<<<< HEAD
public class Food extends Items {

    public Food(String name, int price, int qty) {
        super(name, price, qty);
    }

    @Override
    public String getDescription() {
        return "Food: " + super.getDescription();
=======
public class Food {
    private final String name;
    private final int price;
    private final int qty;

    public Food(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
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
>>>>>>> main
    }
}
