package com.tushar.search.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Movies {
    private Set<String> movieList;

    public Movies() {
        this.movieList = new HashSet<>();
    }

    public List<String> search(String word) {
        if (word.length() < 2) return List.of();
        return movieList.stream()
                .filter(name -> name.substring(0, word.length()).equalsIgnoreCase(word))
                .collect(Collectors.toList());
    }

    public void addMovie(String movie) {
        this.movieList.add(movie);
    }

}
