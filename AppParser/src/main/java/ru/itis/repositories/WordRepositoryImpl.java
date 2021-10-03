package ru.itis.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.model.UniqueWords;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class WordRepositoryImpl implements WordRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(UniqueWords word) {
        entityManager.persist(word);
    }
}
