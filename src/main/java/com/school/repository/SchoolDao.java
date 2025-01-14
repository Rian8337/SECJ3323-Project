package com.school.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.constants.SchoolVerificationStatus;
import com.school.entity.School;

@Repository
public class SchoolDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<School> getAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from School", School.class).list();
        }
    }

    public School getById(final long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(School.class, id);
        }
    }

    public List<School> getPendingSchools() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from School where verification_status = :status", School.class)
                    .setParameter("status", SchoolVerificationStatus.PENDING).list();
        }
    }

    public void save(final School school) {
        try (var session = sessionFactory.openSession()) {
            session.save(school);
        }
    }

    public void update(final School school) {
        try (var session = sessionFactory.openSession()) {
            final var transaction = session.beginTransaction();
            session.update(school);
            transaction.commit();
        }
    }

    public void delete(final School school) {
        try (var session = sessionFactory.openSession()) {
            final var transaction = session.beginTransaction();
            session.delete(school);
            transaction.commit();
        }
    }

    public void delete(final long id) {
        try (var session = sessionFactory.openSession()) {
            final var transaction = session.beginTransaction();
            session.createQuery("delete from School where id = :id").setParameter("id", id).executeUpdate();
            transaction.commit();
        }
    }
    
    public List<School> searchBySchoolName(String keyword) { //edited
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from School where lower(schoolName) like :keyword", School.class) //edited
                    .setParameter("keyword", "%" + keyword.toLowerCase() + "%") //edited
                    .list();
        }
    }

    public List<School> filterByStatus(String status) { //edited
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from School where status = :status", School.class) //edited
                    .setParameter("status", status)
                    .list();
        }
    }

}
