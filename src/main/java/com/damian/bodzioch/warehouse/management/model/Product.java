package com.damian.bodzioch.warehouse.management.model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String code;

    public Product(int id, String name, int quantity, String code) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.code = code;
    }

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getCode() {
        return this.code;
    }

    public int getId(){
        return this.id;
    }
}
