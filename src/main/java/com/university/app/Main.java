package com.university.app;

import com.university.model.*;

public class Main {
    public static void main(String[] args) {

        Movie movie = new Movie3D("Avatar", 160);
        ShowTime showTime = new ShowTime("18:00", movie);
        Customer customer = new Customer("John");
        Seat seat = new Seat(5);

        Booking booking = new Booking(customer, showTime, seat);
        booking.confirmBooking();

        System.out.println("Price: " + movie.calculatePrice());
    }
}
