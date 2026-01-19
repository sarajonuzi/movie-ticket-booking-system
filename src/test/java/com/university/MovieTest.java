package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MovieTest {

    private List<Movie> loadMoviesFromCSV() {
        List<Movie> movies = new ArrayList<>();

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("movies.csv");
            assertNotNull(is, "movies.csv not found!");

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String time = data[2];
                int seats = Integer.parseInt(data[3]);

                ShowTime st = new ShowTime(time, seats);
                List<ShowTime> showTimes = List.of(st);

                // CSV'de type yoksa default 2D alıyoruz
                Movie movie = new Movie2D(id, title, showTimes);
                movies.add(movie);
            }

            br.close();

        } catch (Exception e) {
            fail("CSV loading failed: " + e.getMessage());
        }

        return movies;
    }

    @Test
    public void testMoviesLoadedFromCSV() {
        List<Movie> movies = loadMoviesFromCSV();
        assertFalse(movies.isEmpty());
    }

    @Test
    public void testMovieTitlesFromCSV() {
        List<Movie> movies = loadMoviesFromCSV();
        Movie first = movies.get(0);

        assertNotNull(first.getTitle());
        assertFalse(first.getTitle().isEmpty());
    }

    @Test
    public void testMovieShowTimeExists() {
        List<Movie> movies = loadMoviesFromCSV();
        Movie movie = movies.get(0);

        assertNotNull(movie.getShowTimes());
        assertFalse(movie.getShowTimes().isEmpty());
    }
}
