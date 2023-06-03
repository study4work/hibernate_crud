package com.lysenko.service;

import com.lysenko.entity.Specialty;
import com.lysenko.repository.SpecialtyRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SpecialtyService implements SpecialtyRepository {

    private final Session session;

    public SpecialtyService(Session session) {
        this.session = session;
    }

    public Specialty save(Specialty specialty) {
        Transaction transaction = session.beginTransaction();
        session.save(specialty);
        transaction.commit();
        return specialty;
    }

    public Specialty update(Long id, Specialty specialty) {
        Transaction transaction = session.beginTransaction();
        Specialty specialtyToUpdate= session.get(Specialty.class, id);
        specialtyToUpdate.setDescriptionSpecialty(specialty.getDescriptionSpecialty());
        transaction.commit();
        return specialtyToUpdate;
    }

    public Specialty findById(Long id) {
        Transaction transaction = session.beginTransaction();
        Specialty specialtyToUpdate= session.get(Specialty.class, id);
        transaction.commit();
        return specialtyToUpdate;
    }

    public List<Specialty> findAll() {
        Transaction transaction = session.beginTransaction();
        List<Specialty> specialtyList = session.createQuery("From Specialty", Specialty.class).list();
        transaction.commit();
        return specialtyList;
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();
        Specialty specialtyToUpdate= session.get(Specialty.class, id);
        session.delete(specialtyToUpdate);
        transaction.commit();
    }
}
