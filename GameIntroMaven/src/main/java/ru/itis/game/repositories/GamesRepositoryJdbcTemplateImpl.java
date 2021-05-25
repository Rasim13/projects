package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Game;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class GamesRepositoryJdbcTemplateImpl implements GamesRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GamesRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Game> findAll() {
        return null;
    }

    @Override
    public Optional<Game> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Game account) {

    }

    @Override
    public void update(Game account) {

    }

    @Override
    public void delete(Game account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
