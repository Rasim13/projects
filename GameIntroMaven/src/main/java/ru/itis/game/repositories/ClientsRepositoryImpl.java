package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Client;

import java.util.List;
import java.util.Optional;

@Component
public class ClientsRepositoryImpl implements ClientsRepository {
    //language=SQL
    private static final String SQL_INSERT = "insert into client(ip, date_time) values (?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Optional<Client> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Client account) {
        jdbcTemplate.update(SQL_INSERT, account.getIp(), account.getDateTime().toString());
    }

    @Override
    public void update(Client account) {

    }

    @Override
    public void delete(Client account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
