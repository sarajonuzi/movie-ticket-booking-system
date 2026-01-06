package com.university.movieticket.model.model;

public class Movie3D extends Movie {

    public Movie3D(String title, int duration) {
        super(title, duration);
    }

    @Override
    public double calculatePrice() {
        return 12.0;
    }
}
