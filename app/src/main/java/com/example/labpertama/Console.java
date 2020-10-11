package com.example.labpertama;

public class Console {
    private String name;
    private String description;
    private String price;

    public Console(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrice() {
        return this.price;
    }
}
