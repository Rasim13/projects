package ru.itis.site.repositories;

import ru.itis.site.model.Movie;

import java.util.List;

public interface MovieRepository extends CrudRepository{
    List<Movie> findByMovieContains(String name);
}
