package ru.itis.hibernate.service;

import ru.itis.hibernate.dao.UserDao;
import ru.itis.hibernate.models.Auto;
import ru.itis.hibernate.models.User;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {

    }

    public User findUser(Long id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(Long id) {
        return usersDao.findAutoById(id);
    }


}
