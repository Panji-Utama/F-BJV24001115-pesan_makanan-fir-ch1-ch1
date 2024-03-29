package org.example.model;

public class Food extends Items {

    public Food(String name, int price, int qty) {
        super(name, price, qty);
    }

    @Override
    public String getDescription() {
        return "Food: " + super.getDescription();
    }
}
