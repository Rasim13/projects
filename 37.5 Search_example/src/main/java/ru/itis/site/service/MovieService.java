package ru.itis.site.service;

import ru.itis.site.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> search(String query);

    List<Movie> findAll();
}
