package com.university.model;

public abstract class Movie {

    protected String title;
    protected int duration;

    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public abstract double calculatePrice();

    public String getTitle() {
        return title;
    }
}
