package com.programming.systemdesign.lowleveldesign.moviebookingsystem;

public class Movie {

    private int id;

    private String name;

    private int duration;

    public Movie(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
