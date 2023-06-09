package com.lysenko.service;

import com.lysenko.entity.Developer;
import com.lysenko.repository.DeveloperRepository;
import com.lysenko.repository.hibernateImpl.DeveloperRepositoryImpl;

import java.util.List;

public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService() {
        this.developerRepository = new DeveloperRepositoryImpl();
    }

    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer update(Long id, Developer developer) {
        return developerRepository.update(id, developer);
    }

    public Developer findById(Long id) {
        return developerRepository.findById(id);
    }

    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    public void delete(Long id) {
        developerRepository.delete(id);
    }
}
