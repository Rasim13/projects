package ru.itis.site.repositories;

import ru.itis.site.models.Account;

import java.util.List;
import java.util.Optional;

public interface CrudRepositories<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    void save(T account);
    void update(T account);
    void delete(T account);
    void deleteById(ID id);
}
