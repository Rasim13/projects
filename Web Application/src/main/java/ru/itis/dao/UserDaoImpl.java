package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.mapper.UserMapper;
import ru.itis.models.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //language = SQL
    private static final String SQL_SELECT_ALL = "select * from users";

    //language = SQL
    private static final String SQL_SAVE = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";

    //language = SQL
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";

    //language = SQL
    private static final String SQL_UPDATE = "UPDATE user SET name = ?, email = ?, age = ? WHERE id = ?";

    //language = SQL
    private static final String SQL_DELETE = "DELETE FROM user WHERE id = ?";


    @Override
    public void save(User user) {
        jdbcTemplate.update(SQL_SAVE, user.getName(),user.getEmail(),user.getAge());
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, new UserMapper());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(SQL_UPDATE, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }
}
