package com.university.movieticket.model.model;

public class ShowTime {

    private String time;
    private Movie movie;

    public ShowTime(String time, Movie movie) {
        this.time = time;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
