package com.tushar.search.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    private Movies movies;

    @BeforeEach
    void setup() {
        this.movies = new Movies();
        addData();
    }

    @Test
    @DisplayName("Should not return any movie when movie name length less than 2")
    void testForMovieNameLengthLessThanTwo() {
        List<String> movieList = movies.search("a");

        assertEquals(0, movieList.size());
    }

    @Test
    @DisplayName("Should return 2 movies when movie name starts with Va")
    void testForMovieNameLengthEqualsToTwo() {
        List<String> movieList = movies.search("Va");

        assertEquals(2, movieList.size());
    }

    private void addData() {
      List<String> movieList = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valencia", "Vancouver",
                "Amsterdam", "Vienna", "Sydney", "New York City", "London",
          "Bangkok", "Hong Kong", "Dubai", "Rome", "Istanbul");
      movieList.stream().forEach(movies::addMovie);
    }
}
