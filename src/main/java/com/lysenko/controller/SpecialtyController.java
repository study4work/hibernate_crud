package com.lysenko.controller;

import com.lysenko.entity.Specialty;
import com.lysenko.service.SpecialtyService;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController() {
        this.specialtyService = new SpecialtyService();
    }

    public Specialty save(Specialty specialty) {
        return specialtyService.save(specialty);
    }

    public void update(Long id, Specialty specialty) {
        specialtyService.update(id, specialty);
    }

    public Specialty findById(Long id) {
        return specialtyService.findById(id);
    }

    public List<Specialty> findAll() {
        return specialtyService.findAll();
    }

    public void delete(Long id) {
        specialtyService.delete(id);
    }
}
