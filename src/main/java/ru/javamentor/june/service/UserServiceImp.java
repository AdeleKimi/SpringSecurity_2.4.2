package ru.javamentor.june.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.june.dao.UserDao;
import ru.javamentor.june.dao.UserDaoImp;
import ru.javamentor.june.models.Role;
import ru.javamentor.june.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserServiceImp")
@Transactional
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
    public void addRole(User user, Role role) {
        Set<Role> roleSet;

        if (user.getRoles() != null) {
            roleSet = user.getRoles();
        } else {
            roleSet = new HashSet<>();
        }
        roleSet.add(role);
        user.setRoles(roleSet);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id,user);

    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(s);
    }
}
