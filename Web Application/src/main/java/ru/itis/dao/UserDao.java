package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getById(int id);

    List<User> findAll();

    void update(User user);

    void delete(int id);
}
