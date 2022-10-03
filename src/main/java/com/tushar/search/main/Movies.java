package com.tushar.search.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Movies {
    public static final int MIN_VALUE = 2;
    private final Set<Movie> movieList;

    public Movies() {
        this.movieList = new HashSet<>();
    }

    public List<Movie> search(String word) {
        if (word.length() < MIN_VALUE) return List.of();
        return movieList.stream()
                .filter(d -> d.hasMovieStartedWith(word))
                .toList();
    }

    public void addMovie(String movie) {
        this.movieList.add(new Movie(movie));
    }

}
