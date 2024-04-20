package org.example.model;

public class Drink extends Items {

    public Drink(String name, int price, int qty) {
        super(name, price, qty);
    }

    @Override
    public String getDescription() {
        return "Drink: " + super.getDescription();
    }
}
