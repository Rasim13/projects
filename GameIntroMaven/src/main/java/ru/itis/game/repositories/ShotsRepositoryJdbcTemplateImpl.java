package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Shot;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class ShotsRepositoryJdbcTemplateImpl implements ShotsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShotsRepositoryJdbcTemplateImpl (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Shot> findAll() {
        return null;
    }

    @Override
    public Optional<Shot> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Shot account) {

    }

    @Override
    public void update(Shot account) {

    }

    @Override
    public void delete(Shot account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
