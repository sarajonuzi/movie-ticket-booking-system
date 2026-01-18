package com.university;

public class Customer {

    private static int counter = 1;
    private int id;
    private String name;

    public Customer(String name) {
        this.id = counter++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
