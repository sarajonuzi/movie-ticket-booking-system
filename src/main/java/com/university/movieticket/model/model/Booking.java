package com.university.movieticket.model.model;

import com.university.movieticket.service.Bookable;

public class Booking implements Bookable {

    private Customer customer;
    private ShowTime showTime;
    private Seat seat;

    public Booking(Customer customer, ShowTime showTime, Seat seat) {
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;
    }

    @Override
    public void confirmBooking() {
        seat.book();
        System.out.println("Booking confirmed for " + customer.getName());
    }
}
