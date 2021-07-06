package ru.javamentor.june.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.javamentor.june.models.Role;
import ru.javamentor.june.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> getAll();

    public User getUserById(long id);

    public void saveUser(User user);

    public void deleteUser(long id);

    public void updateUser(long id, User user);

    public void addRole(User user, Role role);

    public User findByUserName(String username);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
