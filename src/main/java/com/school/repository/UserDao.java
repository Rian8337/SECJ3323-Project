package com.school.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.entity.User;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    public User getById(final long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public User getByEmail(final String email) {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}