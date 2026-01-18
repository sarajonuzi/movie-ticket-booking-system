package com.university.movieticket.model.model;

public class Movie2D extends Movie {

    public Movie2D(String title, int duration) {
        super(title, duration);
    }

    @Override
    public double calculatePrice() {
        return 8.0;
    }
}

