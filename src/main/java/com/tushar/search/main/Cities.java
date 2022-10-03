package com.tushar.search.main;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cities {
    public static final int MIN_VALUE = 2;
    private final Set<City> cityList;

    public Cities() {
        this.cityList = new HashSet<>();
    }

    public Set<City> search(String word) {
        if (word.startsWith("*")) return cityList;
        if (word.length() < MIN_VALUE) return Set.of();
        return cityList.stream()
                .filter(d -> d.hasNameContains(word))
                .collect(Collectors.toSet());
    }

    public void addCity(String city) {
        this.cityList.add(new City(city));
    }

}
