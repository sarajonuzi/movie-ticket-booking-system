package com.university;

import java.util.ArrayList;
import java.util.List;

public class ShowTime {

    private String time;
    private List<Seat> seats;

    public ShowTime(String time, int seatCount) {
        this.time = time;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i));
        }
    }

    public String getTime() {
        return time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // Seat map visualization
    public void printSeatMap() {
        System.out.println("\nSeat Map:");
        for (Seat s : seats) {
            if (s.isReserved()) {
                System.out.print("[X] ");
            } else {
                System.out.print("[" + s.getSeatNumber() + "] ");
            }
        }
        System.out.println();
    }
}
