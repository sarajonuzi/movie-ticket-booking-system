package com.university;

public class Seat {

    private int seatNumber;
    private boolean reserved;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean reserve() {
        if (!reserved) {
            reserved = true;
            return true;
        }
        return false;
    }

    public void cancel() {
        reserved = false;
    }
}
