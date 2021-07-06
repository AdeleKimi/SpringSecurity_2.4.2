package ru.javamentor.june.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.javamentor.june.models.User;

import java.util.List;

public interface UserDao extends UserDetailsService {
    public List<User> getAll();

    public User getUserById(long id);

    public void saveUser(User user);

    public void deleteUser(long id);

    public void updateUser(long id, User user);

    public User findByUserName(String username);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
