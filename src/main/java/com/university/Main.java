package com.university;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class
Main {

    private static List<Movie> movies = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {


        loadMoviesFromCSV();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CINEMA BOOKING SYSTEM =====");
            System.out.println("1. List Movies");

            System.out.println("2. Book Ticket");
            System.out.println("3. Booking History");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) listMovies();
            else if (choice == 2) book(sc);
            else if (choice == 3) showBookingHistory();
            else if (choice == 4) cancelBooking(sc);
            else break;
        }
    }

    // Load movies from CSV: id,title,time,seats
    private static void loadMoviesFromCSV() {
        try {
            InputStream is = Main.class.getClassLoader().getResourceAsStream("movies.csv");

            if (is == null) {
                System.out.println("movies.csv not found!");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String time = data[2];
                int seatCount = Integer.parseInt(data[3]);

                ShowTime showTime = new ShowTime(time, seatCount);
                List<ShowTime> showTimes = List.of(showTime);

                Movie movie;
                if (title.equalsIgnoreCase("Dune")) {
                    movie = new Movie3D(id, title, showTimes);
                } else {
                    movie = new Movie2D(id, title, showTimes);
                }

                movies.add(movie);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("CSV Error: " + e.getMessage());
        }
    }

    private static void listMovies() {
        System.out.println("\n--- Movies ---");
        for (Movie m : movies) {
            System.out.println(m.getId() + ". " + m.getTitle() +
                    " (" + m.getClass().getSimpleName() + ")");
        }
    }

    private static void book(Scanner sc) {

        System.out.print("Your name: ");
        sc.nextLine();
        Customer customer = new Customer(sc.nextLine());

        listMovies();
        System.out.print("Select movie id: ");
        int id = sc.nextInt();

        Movie selected = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (selected == null) {
            System.out.println("Movie not found!");
            return;
        }

        ShowTime st = selected.getShowTimes().get(0);

        System.out.println("\nShowtime: " + st.getTime());
        st.printSeatMap();

        System.out.print("\nSelect seat number: ");
        int seatNo = sc.nextInt();
        Seat seat = st.getSeats().get(seatNo - 1);

        if (!selected.bookSeat(seat)) {
            System.out.println("Seat already reserved!");
            return;
        }

        System.out.print("Do you have student discount? (yes/no): ");
        sc.nextLine();
        String answer = sc.nextLine();
        boolean discounted = answer.equalsIgnoreCase("yes");

        Booking booking = new Booking(customer, selected, st, seat, discounted);
        bookings.add(booking);

        System.out.println("\nBooking confirmed!");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Movie: " + selected.getTitle());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Price: $" + booking.getPrice());
    }

    private static void showBookingHistory() {
        System.out.println("\n--- Booking History ---");

        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println(
                    "Booking ID: " + b.getBookingId() +
                            " | Customer: " + b.getCustomer().getName() +
                            " | Movie: " + b.getMovie().getTitle() +
                            " | Showtime: " + b.getShowTime().getTime() +
                            " | Seat: " + b.getSeat().getSeatNumber() +
                            " | Price: $" + b.getPrice() +
                            (b.isDiscounted() ? " (Discounted)" : "")
            );
        }
    }

    private static void cancelBooking(Scanner sc) {
        showBookingHistory();

        if (bookings.isEmpty()) return;

        System.out.print("\nEnter Booking ID to cancel: ");
        int id = sc.nextInt();

        for (Booking b : bookings) {
            if (b.getBookingId() == id) {
                b.getSeat().cancel();
                bookings.remove(b);
                System.out.println("Booking cancelled successfully!");
                return;
            }
        }

        System.out.println("Booking not found!");
    }
}
