package com.lysenko.controller;

import com.lysenko.entity.Developer;
import com.lysenko.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public Developer save(Developer developer) {
        return developerService.save(developer);
    }

    public void update(Long id, Developer developer) {
        developerService.update(id, developer);
    }

    public Developer findById(Long id) {
        return developerService.findById(id);
    }

    public List findAll() {
        return developerService.findAll();
    }

    public void delete(Long id) {
        developerService.delete(id);
    }
}
