package com.example.pp_3_1_1_springboot.dao;


import com.example.pp_3_1_1_springboot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getUsersWithLogin(String login) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.login LIKE :login", User.class)
                .setParameter("login", login)
                .getResultList();
    }

    @Override
    public List<User> getUsersWithAgeBetweenMinAndMax(byte min, byte max) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.age BETWEEN :min AND :max", User.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }

    @Override
    public void truncateTable() {
        entityManager.createQuery("DELETE FROM User").executeUpdate();
    }
}
