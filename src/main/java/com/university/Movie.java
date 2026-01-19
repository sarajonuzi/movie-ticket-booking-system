package com.university;

import java.util.List;

public abstract class Movie implements Bookable {

    private int id;
    private String title;
    private List<ShowTime> showTimes;

    public Movie(int id, String title, List<ShowTime> showTimes) {
        this.id = id;
        this.title = title;
        this.showTimes = showTimes;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    // Polymorphism → 2D ve 3D fiyatı farklı olacak
    public abstract double calculatePrice();

    // Interface method
    @Override
    public boolean bookSeat(Seat seat) {
        return seat.reserve();
    }
}
