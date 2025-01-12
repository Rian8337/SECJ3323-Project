package com.school.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.entity.Content;
import com.school.entity.User;

@Repository
public class ContentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Content> getAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from Content", Content.class).list();
        }
    }

    public Content getById(final long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(Content.class, id);
        }
    }

    public List<Content> getByUser(final User user) {
        return getByUser(user.getId());
    }

    public List<Content> getByUser(final long userId) {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from Content where user_id = :userId", Content.class)
                    .setParameter("userId", userId).list();
        }
    }

    @Transactional
    public void save(final Content content) {
        try (var session = sessionFactory.openSession()) {
            session.save(content);
        }
    }

    @Transactional
    public void update(final Content content) {
        try (var session = sessionFactory.openSession()) {
            session.update(content);
        }
    }

    @Transactional
    public void delete(final Content content) {
        try (var session = sessionFactory.openSession()) {
            session.delete(content);
        }
    }

    @Transactional
    public void delete(final long id) {
        try (var session = sessionFactory.openSession()) {
            session.createQuery("delete from Content where id = :id").setParameter("id", id).executeUpdate();
        }
    }
}
