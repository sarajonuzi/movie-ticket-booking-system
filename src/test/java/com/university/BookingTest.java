package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BookingTest {

    @Test
    public void testSeatReservation() {
        Seat seat = new Seat(1);
        assertTrue(seat.reserve());
        assertFalse(seat.reserve()); // cannot reserve twice
    }

    @Test
    public void testCancelSeat() {
        Seat seat = new Seat(1);
        seat.reserve();
        seat.cancel();
        assertFalse(seat.isReserved());
    }

    @Test
    public void test2DMoviePrice() {
        Movie movie = new Movie2D(1, "Test Movie", List.of(new ShowTime("20:00", 10)));
        assertEquals(10.0, movie.calculatePrice());
    }

    @Test
    public void test3DMoviePrice() {
        Movie movie = new Movie3D(1, "Test Movie", List.of(new ShowTime("20:00", 10)));
        assertEquals(15.0, movie.calculatePrice());
    }

    @Test
    public void testBookingWithDiscount() {
        Customer c = new Customer("Sara");
        Movie movie = new Movie2D(1, "Test", List.of(new ShowTime("20:00", 10)));
        ShowTime st = movie.getShowTimes().get(0);
        Seat seat = st.getSeats().get(0);

        Booking booking = new Booking(c, movie, st, seat, true);

        assertEquals(8.0, booking.getPrice()); // 20% discount from 10
    }

    @Test
    public void testBookingWithoutDiscount() {
        Customer c = new Customer("Sara");
        Movie movie = new Movie2D(1, "Test", List.of(new ShowTime("20:00", 10)));
        ShowTime st = movie.getShowTimes().get(0);
        Seat seat = st.getSeats().get(0);

        Booking booking = new Booking(c, movie, st, seat, false);

        assertEquals(10.0, booking.getPrice());
    }
}
