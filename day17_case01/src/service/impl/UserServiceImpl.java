package service.impl;

import dao.impl.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User updateUser(int id) {
        return userDao.updateUser(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.motifyUser(user);
    }
}
