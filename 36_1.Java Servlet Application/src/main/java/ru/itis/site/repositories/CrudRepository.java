package ru.itis.site.repositories;

import ru.itis.site.models.Account;

import java.util.List;

public interface CrudRepository<T, ID> {
    List<T> findAll();
}
