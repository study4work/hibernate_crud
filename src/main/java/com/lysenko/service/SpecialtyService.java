package com.lysenko.service;

import com.lysenko.entity.Skill;
import com.lysenko.entity.Specialty;
import com.lysenko.repository.SpecialtyRepository;
import com.lysenko.repository.hibernateImpl.SpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService() {
        this.specialtyRepository = new SpecialtyRepositoryImpl();
    }

    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty update(Long id ,Specialty specialty) {
        return specialtyRepository.update(id ,specialty);
    }

    public Specialty findById(Long id) {
        return specialtyRepository.findById(id);
    }

    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    public void delete(Long id) {
        specialtyRepository.delete(id);
    }
}
