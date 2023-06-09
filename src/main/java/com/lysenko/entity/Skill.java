package com.lysenko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill {

    public Skill() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;
    @Column(name = "skill_description")
    private String skillDescription;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToMany()
    @JoinTable(name = "developer_skill", joinColumns = @JoinColumn(name = "skill_id"), inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Developer> developerList = new ArrayList<>();



    public void addDeveloper(Developer developer) {
        developerList.add(developer);
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Skill{" +
            "id=" + id +
            ", skillDescription='" + skillDescription + '\'' +
            ", status=" + status +
            '}';
    }
}
