package ru.javamentor.june.dao;

import org.springframework.stereotype.Component;
import ru.javamentor.june.models.Role;
import ru.javamentor.june.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery(
                "select role  from Role role where role.id = :id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public List<Role> getAllRoles() {

        return entityManager.createQuery("select u from Role u ",Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery(
                "select role  from Role role where role.name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
