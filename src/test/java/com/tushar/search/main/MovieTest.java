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
    @DisplayName("Should search for case-insensitive string")
    void testSearchForCaseInsensitiveLongString() {
        List<String> movieList = searchMovies("bang");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains("Bangkok"));
        assertTrue(movieList.contains("Bangalore"));
    }

    @Test
    @DisplayName("Should test for movie when word is part of the input")
    void testSearchForMovieWhenWordIsPartOfInput() {
        List<String> movieList = searchMovies("ape");

        assertEquals(1, movieList.size());
        assertTrue(movieList.contains("Budapest"));
    }

    @Test
    @DisplayName("Should return all movies when search word is asterisk")
    void testForAsterisk() {
        List<String> movieList = searchMovies("*");

        assertEquals(17, movieList.size());
    }
    private void addData() {
      List<String> movieList = List.of("Paris", "Budapest", "Skopje", "Rotterdam",
               "Valencia", "Vancouver",
                "Amsterdam", "Vienna", "Sydney", "New York City", "London",
          "Bangkok", "Hong Kong", "Dubai", "Rome", "Istanbul", "Bangalore");
      movieList.forEach(movies::addMovie);
    }

    private List<String> searchMovies(String word) {
        return movies.search(word)
                .stream()
                .map(Movie::name).toList();
    }


}
