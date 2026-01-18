package com.university;

import java.util.List;

public abstract class Movie implements Bookable {

    protected int id;
    protected String title;
    protected List<ShowTime> showTimes;

    public Movie(int id, String title, List<ShowTime> showTimes) {
        this.id = id;
        this.title = title;
        this.showTimes = showTimes;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public List<ShowTime> getShowTimes() { return showTimes; }

    public abstract double calculatePrice();
}
