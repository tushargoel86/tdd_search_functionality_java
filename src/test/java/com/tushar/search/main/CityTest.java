package com.tushar.search.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {

    private Cities cities;

    @BeforeEach
    void setup() {
        this.cities = new Cities();
        addData();
    }

    @Test
    @DisplayName("Should not return any city when city name length less than 2")
    void testForCityNameLengthLessThanTwo() {
        List<String> cityList = searchCities("a");

        assertEquals(0, cityList.size());
    }

    @Test
    @DisplayName("Should return 2 cities when city name starts with Va")
    void testForCityNameLengthEqualsToTwo() {
        List<String> cityList = searchCities("Va");

        assertEquals(2, cityList.size());
        assertTrue(cityList.contains("Vancouver"));
        assertTrue(cityList.contains("Valencia"));
    }

    @Test
    @DisplayName("Should allow a search based on case insensitive")
    void testForCityNameWithCaseInsensitive() {
        List<String> cityList = searchCities("va");

        assertEquals(2, cityList.size());
        assertTrue(cityList.contains("Vancouver"));
        assertTrue(cityList.contains("Valencia"));
    }

    @Test
    @DisplayName("Should search for case-insensitive string")
    void testSearchForCaseInsensitiveLongString() {
        List<String> cityList = searchCities("bang");

        assertEquals(2, cityList.size());
        assertTrue(cityList.contains("Bangkok"));
        assertTrue(cityList.contains("Bangalore"));
    }

    @Test
    @DisplayName("Should test for movie when word is part of the input")
    void testSearchForCityWhenWordIsPartOfInput() {
        List<String> cityList = searchCities("ape");

        assertEquals(1, cityList.size());
        assertTrue(cityList.contains("Budapest"));
    }

    @Test
    @DisplayName("Should return all movies when search word is asterisk")
    void testForAsterisk() {
        List<String> cityList = searchCities("*");

        assertEquals(17, cityList.size());
    }
    private void addData() {
      List<String> cityList = List.of("Paris", "Budapest", "Skopje", "Rotterdam",
               "Valencia", "Vancouver",
                "Amsterdam", "Vienna", "Sydney", "New York City", "London",
          "Bangkok", "Hong Kong", "Dubai", "Rome", "Istanbul", "Bangalore");
      cityList.forEach(cities::addCity);
    }

    private List<String> searchCities(String word) {
        return cities.search(word)
                .stream()
                .map(City::name).toList();
    }


}
