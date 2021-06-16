package ru.javamentor.june.dao;

import org.springframework.stereotype.Component;
import ru.javamentor.june.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select user  from User user where user.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User newUser) {
//        User user = entityManager.find(User.class,id);
//        user.setName(newUser.getName());
//        user.setEmail(newUser.getEmail());
        entityManager.merge(newUser);


    }
}
