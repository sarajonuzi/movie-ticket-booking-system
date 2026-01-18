package com.university;

public class Booking {

    private static int counter = 1;

    private int bookingId;
    private Customer customer;
    private Movie movie;
    private ShowTime showTime;
    private Seat seat;
    private double price;
    private boolean discounted;

    public Booking(Customer customer, Movie movie, ShowTime showTime, Seat seat, boolean discounted) {
        this.bookingId = counter++;
        this.customer = customer;
        this.movie = movie;
        this.showTime = showTime;
        this.seat = seat;
        this.discounted = discounted;

        double basePrice = movie.calculatePrice();
        this.price = discounted ? basePrice * 0.8 : basePrice;
    }

    public int getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Movie getMovie() { return movie; }
    public ShowTime getShowTime() { return showTime; }
    public Seat getSeat() { return seat; }
    public double getPrice() { return price; }
    public boolean isDiscounted() { return discounted; }
}
