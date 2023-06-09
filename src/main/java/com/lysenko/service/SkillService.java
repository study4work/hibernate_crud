package com.lysenko.service;

import com.lysenko.entity.Skill;
import com.lysenko.repository.SkillRepository;
import com.lysenko.repository.hibernateImpl.SkillRepositoryImpl;

import java.util.List;

public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService() {
        this.skillRepository = new SkillRepositoryImpl();
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill update(Long id ,Skill skill) {
        return skillRepository.update(id ,skill);
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public void delete(Long id) {
        skillRepository.delete(id);
    }
}
