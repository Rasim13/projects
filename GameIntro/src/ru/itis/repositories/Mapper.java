package ru.itis.repositories;

public interface Mapper<T, V> {
    V map(T object);
}
