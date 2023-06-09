package com.lysenko.repository.hibernateImpl;

import com.lysenko.config.HibernateConfig;
import com.lysenko.entity.Developer;
import com.lysenko.repository.DeveloperRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    public Developer save(Developer developer) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Something wring with persist Developer" + e);
        }
        return developer;
    }

    public Developer update(Long id, Developer developer) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Developer developerToUpdate = session.get(Developer.class, id);
            developerToUpdate.setFirstName(developer.getFirstName());
            developerToUpdate.setLastName(developer.getLastName());
            session.update(developerToUpdate);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Something wring with update Developer" + e);
        }
        return developer;
    }

    public Developer findById(Long id) {
        return HibernateConfig.getSession().get(Developer.class, id);
    }

    public List<Developer> findAll() {
        return HibernateConfig.getSession().createQuery("SELECT d FROM Developer d left join fetch d.skills left join fetch d.specialty", Developer.class).list();
    }

    public void delete(Long id) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Developer developerToUpdate = session.get(Developer.class, id);
            session.delete(developerToUpdate);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Something wring with delete Developer" + e);
        }
    }
}
