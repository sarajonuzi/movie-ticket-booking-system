package com.university;

import java.util.List;

public class Movie3D extends Movie {

    public Movie3D(int id, String title, List<ShowTime> showTimes) {
        super(id, title, showTimes);
    }

    @Override
    public double calculatePrice() {
        return 15.0; // premium price
    }

    @Override
    public boolean bookSeat(Seat seat) {
        return seat.reserve();
    }
}
