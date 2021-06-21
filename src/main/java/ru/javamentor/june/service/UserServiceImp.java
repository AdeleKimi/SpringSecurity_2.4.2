package ru.javamentor.june.service;

import org.springframework.stereotype.Component;
import ru.javamentor.june.dao.UserDao;
import ru.javamentor.june.dao.UserDaoImp;
import ru.javamentor.june.models.User;

import java.util.List;
@Component
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    public UserServiceImp(UserDaoImp userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id,user);

    }
}
