package com.lysenko.repository.hibernateImpl;

import com.lysenko.config.HibernateConfig;
import com.lysenko.entity.Specialty;
import com.lysenko.repository.SpecialtyRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SpecialtyRepositoryImpl implements SpecialtyRepository {

    public Specialty save(Specialty specialty) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(specialty);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Something wring with persist Specialty" + e);
        }
        return specialty;
    }

    public Specialty update(Long id, Specialty specialty) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Specialty specialtyToUpdate = session.get(Specialty.class, id);
            specialtyToUpdate.setDescriptionSpecialty(specialty.getDescriptionSpecialty());
            transaction.commit();
            return specialtyToUpdate;
        } catch (Exception e) {
            throw new RuntimeException("Something wring with update Specialty" + e);
        }
    }

    public Specialty findById(Long id) {
        return HibernateConfig.getSession().get(Specialty.class, id);
    }

    public List<Specialty> findAll() {
        return HibernateConfig.getSession().createQuery("from Specialty", Specialty.class).list();
    }

    public void delete(Long id) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Specialty specialtyToUpdate = session.get(Specialty.class, id);
            session.delete(specialtyToUpdate);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Something wring with update Specialty" + e);
        }
    }
}
