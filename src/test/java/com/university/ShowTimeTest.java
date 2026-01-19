package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShowTimeTest {

    @Test
    public void testSeatCount() {
        ShowTime st = new ShowTime("19:00", 20);
        assertEquals(20, st.getSeats().size());
    }

    @Test
    public void testSeatReservationFromShowTime() {
        ShowTime st = new ShowTime("22:00", 5);
        Seat seat = st.getSeats().get(0);

        assertTrue(seat.reserve());
        assertTrue(seat.isReserved());
    }
}
