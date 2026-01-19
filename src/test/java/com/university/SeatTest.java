package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeatTest {

    @Test
    public void testSeatInitialState() {
        Seat seat = new Seat(1);
        assertFalse(seat.isReserved());
    }

    @Test
    public void testSeatReservation() {
        Seat seat = new Seat(2);
        assertTrue(seat.reserve());
        assertTrue(seat.isReserved());
    }

    @Test
    public void testSeatCancel() {
        Seat seat = new Seat(3);
        seat.reserve();
        seat.cancel();
        assertFalse(seat.isReserved());
    }
}
