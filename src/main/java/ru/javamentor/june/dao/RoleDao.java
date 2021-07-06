package ru.javamentor.june.dao;

import ru.javamentor.june.models.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
