package com.university;

public class User {

    private static int counter = 1;

    private int id;
    private String name;

    public User(String name) {
        this.id = counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
