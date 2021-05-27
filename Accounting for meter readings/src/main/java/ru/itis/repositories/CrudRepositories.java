package ru.itis.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepositories<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    Optional<T> findByFlat(ID numberOfFlat);
    void save(T account);
    void update(T account);
    void delete(T account);
    void deleteById(ID id);
}
