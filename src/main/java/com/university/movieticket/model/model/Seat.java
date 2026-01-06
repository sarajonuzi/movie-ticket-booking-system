package com.university.movieticket.model.model;

public class Seat {

    private int seatNumber;
    private boolean booked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }

    public void book() {
        this.booked = true;
    }

    public boolean isBooked() {
        return booked;
    }
}
