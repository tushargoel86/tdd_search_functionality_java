package com.tushar.search.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<String> movieList = searchMovies("a");

        assertEquals(0, movieList.size());
    }

    @Test
    @DisplayName("Should return 2 movies when movie name starts with Va")
    void testForMovieNameLengthEqualsToTwo() {
        List<String> movieList = searchMovies("Va");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains("Vancouver"));
        assertTrue(movieList.contains("Valencia"));
    }

    @Test
    @DisplayName("Should allow a search based on case insensitive")
    void testForMovieNameWithCaseInsensitive() {
        List<String> movieList = searchMovies("va");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains("Vancouver"));
        assertTrue(movieList.contains("Valencia"));
    }

    @Test
    void testSearchForCaseInsensitiveLongString() {
        List<String> movieList = searchMovies("bang");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains("Bangkok"));
        assertTrue(movieList.contains("Bangalore"));
    }

    private void addData() {
      List<String> movieList = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valencia", "Vancouver",
                "Amsterdam", "Vienna", "Sydney", "New York City", "London",
          "Bangkok", "Hong Kong", "Dubai", "Rome", "Istanbul", "Bangalore");
      movieList.stream().forEach(movies::addMovie);
    }

    private List<String> searchMovies(String word) {
        return movies.search(word)
                .stream()
                .map(Movie::name).toList();
    }


}
