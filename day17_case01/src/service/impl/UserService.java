package service.impl;

import entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void addUser(User user);
    void deleteUser(User user);
    User updateUser(int id);

    void modifyUser(User user);
}
