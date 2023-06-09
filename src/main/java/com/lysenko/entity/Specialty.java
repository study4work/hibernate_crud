package com.lysenko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Specialty {

    public Specialty() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private long id;
    @Column(name = "specialty_description")
    private String descriptionSpecialty;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne(mappedBy = "specialty", fetch = FetchType.LAZY)
    private Developer developer;

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescriptionSpecialty() {
        return descriptionSpecialty;
    }

    public void setDescriptionSpecialty(String descriptionSpecialty) {
        this.descriptionSpecialty = descriptionSpecialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Specialty{" +
            "id=" + id +
            ", descriptionSpecialty='" + descriptionSpecialty + '\'' +
            ", status=" + status +
            '}';
    }
}
