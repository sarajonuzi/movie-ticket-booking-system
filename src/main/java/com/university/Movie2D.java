package com.university;

import java.util.List;

public class Movie2D extends Movie {

    public Movie2D(int id, String title, List<ShowTime> showTimes) {
        super(id, title, showTimes);
    }

    @Override
    public double calculatePrice() {
        return 10.0;
    }

    @Override
    public boolean bookSeat(Seat seat) {
        return seat.reserve();
    }
}
