package ru.javamentor.june.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javamentor.june.dao.UserDaoImp;
import ru.javamentor.june.models.User;

import java.util.List;
@Component
public class UserServiceImp implements UserService{
    private final UserDaoImp userDaoImp;

    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public List<User> getAll() {
        return userDaoImp.getAll();
    }

    @Override
    public User getUserById(long id) {
        return userDaoImp.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDaoImp.saveUser(user);

    }

    @Override
    public void deleteUser(long id) {
        userDaoImp.deleteUser(id);
    }

    @Override
    public void updateUser(long id, User user) {
        userDaoImp.updateUser(id,user);

    }
}
