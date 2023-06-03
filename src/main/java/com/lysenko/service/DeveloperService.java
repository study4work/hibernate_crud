package com.lysenko.service;

import com.lysenko.entity.Developer;
import com.lysenko.repository.DeveloperRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperService implements DeveloperRepository {

    private final Session session;

    public DeveloperService(Session session) {
        this.session = session;
    }

    public Developer save(Developer developer) {
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        return developer;
    }

    public Developer update(Long id, Developer developer) {
        Transaction transaction = session.beginTransaction();
        Developer developerToUpdate = session.get(Developer.class, id);
        developerToUpdate.setFirstName(developer.getFirstName());
        developerToUpdate.setLastName(developer.getLastName());
        session.update(developerToUpdate);
        transaction.commit();
        return developer;
    }

    public Developer findById(Long id) {
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        transaction.commit();
        return developer;
    }

    public List<Developer> findAll() {
        Transaction transaction = session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM developer", Developer.class).list();
        transaction.commit();
        return developers;
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();
        Developer developerToUpdate = session.get(Developer.class, id);
        session.delete(developerToUpdate);
        transaction.commit();
    }
}
