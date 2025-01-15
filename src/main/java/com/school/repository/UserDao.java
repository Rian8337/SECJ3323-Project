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

    public User getByName(final String name) {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from User where name = :name", User.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public User getByEmail(final String email) {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public void save(final User user) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public void update(final User user) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    public void delete(final long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            final var user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}