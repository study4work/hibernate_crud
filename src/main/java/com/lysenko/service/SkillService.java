package com.lysenko.service;

import com.lysenko.entity.Skill;
import com.lysenko.repository.SkillRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillService implements SkillRepository {

    private final Session session;

    public SkillService(Session session) {
        this.session = session;
    }

    public Skill save(Skill skill) {
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        return skill;
    }

    public Skill update(Long id, Skill skill) {
        Transaction transaction = session.beginTransaction();
        Skill skillToUpdate = session.get(Skill.class, id);
        skillToUpdate.setSkillDescription(skill.getSkillDescription());
        transaction.commit();
        return skill;
    }

    public Skill findById(Long id) {
        Transaction transaction = session.beginTransaction();
        Skill skillToUpdate = session.get(Skill.class, id);
        transaction.commit();
        return skillToUpdate;
    }

    public List<Skill> findAll() {
        Transaction transaction = session.beginTransaction();
        List<Skill> skillList = session.createQuery("FROM Skill", Skill.class).list();
        transaction.commit();
        return skillList;
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();
        Skill skillToUpdate = session.get(Skill.class, id);
        session.delete(skillToUpdate);
        transaction.commit();
    }
}
