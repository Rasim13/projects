package ru.itis.repositories;

import ru.itis.model.UniqueWords;

public interface WordRepository {
    void save(UniqueWords word);
}
