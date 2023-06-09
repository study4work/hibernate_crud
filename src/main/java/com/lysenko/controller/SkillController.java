package com.lysenko.controller;

import com.lysenko.entity.Skill;
import com.lysenko.service.SkillService;

import java.util.List;

public class SkillController {

    private final SkillService skillService;

    public SkillController() {
        this.skillService = new SkillService();
    }

    public Skill save(Skill skill) {
        return skillService.save(skill);
    }

    public void update(Long id, Skill skill) {
        skillService.update(id, skill);
    }

    public Skill findById(Long id) {
        return skillService.findById(id);
    }

    public List<Skill> findAll() {
        return skillService.findAll();
    }

    public void delete(Long id) {
        skillService.delete(id);
    }
}
