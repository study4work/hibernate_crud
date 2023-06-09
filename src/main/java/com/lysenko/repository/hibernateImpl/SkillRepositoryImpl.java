package com.lysenko.repository.hibernateImpl;

import com.lysenko.config.HibernateConfig;
import com.lysenko.entity.Skill;
import com.lysenko.repository.SkillRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {

    public Skill save(Skill skill) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(skill);
            transaction.commit();
            return skill;
        } catch (Exception e) {
            throw new RuntimeException("Something wring with persist Skill" + e);
        }
    }

    public Skill update(Long id, Skill skill) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Skill skillToUpdate = session.get(Skill.class, id);
            skillToUpdate.setSkillDescription(skill.getSkillDescription());
            transaction.commit();
            return skill;
        } catch (Exception e) {
            throw new RuntimeException("Something wring with update Skill" + e);
        }
    }

    public Skill findById(Long id) {
        return HibernateConfig.getSession().get(Skill.class, id);
    }

    public List<Skill> findAll() {
        return HibernateConfig.getSession().createQuery("FROM Skill", Skill.class).list();
    }

    public void delete(Long id) {
        try (Session session = HibernateConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            Skill skillToUpdate = session.get(Skill.class, id);
            session.delete(skillToUpdate);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Something wring with delete Skill" + e);
        }
    }
}
