package com.tushar.search.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    @DisplayName("Should not return any movie when movie name length less than 2")
    void testForMovieNameLengthLessThanTwo() {
        Movies movie = new Movies();
        List<String> movies = movie.search("a");

        assertEquals(0, movies.size());
    }

    @Test
    @DisplayName("Should return 2 movies when movie name starts with Va")
    void testForMovieNameLengthEqualsToTwo() {
        Movies movie = new Movies();
        List<String> movies = movie.search("Va");

        assertEquals(2, movies.size());
    }
}
