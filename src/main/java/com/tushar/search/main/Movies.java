package com.tushar.search.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Movies {
    public static final int MIN_VALUE = 2;
    private final Set<Movie> movieList;

    public Movies() {
        this.movieList = new HashSet<>();
    }

    public Set<Movie> search(String word) {
        if (word.startsWith("*")) return movieList;
        if (word.length() < MIN_VALUE) return Set.of();
        return movieList.stream()
                .filter(d -> d.hasNameContains(word))
                .collect(Collectors.toSet());
    }

    public void addMovie(String movie) {
        this.movieList.add(new Movie(movie));
    }

}
