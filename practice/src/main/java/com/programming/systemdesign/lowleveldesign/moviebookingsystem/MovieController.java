package com.programming.systemdesign.lowleveldesign.moviebookingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    private Map<String, List<Movie>> moviesByCity;

    private List<Movie> movies;

    public MovieController() {
        this.moviesByCity = new HashMap<>();
        this.movies = new ArrayList<>();
    }

    public Map<String, List<Movie>> getMoviesByCity() {
        return moviesByCity;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
