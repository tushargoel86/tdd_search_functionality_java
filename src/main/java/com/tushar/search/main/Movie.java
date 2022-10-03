package com.tushar.search.main;

import java.util.Objects;

public record Movie(String name) {

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean hasNameContains(String word) {
        return name.toLowerCase().contains(word.toLowerCase());
    }
}
