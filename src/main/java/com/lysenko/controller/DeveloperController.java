package com.lysenko.controller;

import com.lysenko.entity.Developer;
import com.lysenko.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController() {
        this.developerService = new DeveloperService();
    }

    public Developer save(Developer developer) {
        return developerService.save(developer);
    }

    public Developer update(Long id, Developer developer) {
        return developerService.update(id, developer);
    }

    public Developer findById(Long id) {
        return developerService.findById(id);
    }

    public List<Developer> findAll() {
        return developerService.findAll();
    }

    public void delete(Long id) {
        developerService.delete(id);
    }
}
