package dao.impl;

import entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void addUser(User user);
    void createTable();
    void deleteUser(User user);

    User updateUser(int id);

    void motifyUser(User user);
}
