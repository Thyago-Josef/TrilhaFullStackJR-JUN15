package com.projetocodigocerto.api.entitiy;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//import javax.persistence.Id;

@Entity
@Table(name= "project_table")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;

    private String name_project;

    private String description_project;

    private Date date_project;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "project_language",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_language"))
    private Set<Language> languages = new HashSet<>();

    public Project() {
    }

    public Project(Long id_project, String name_project, String description_project, Date date_project, Set<Language> languages) {
        this.id_project = id_project;
        this.name_project = name_project;
        this.description_project = description_project;
        this.date_project = date_project;
        this.languages = languages;
    }

    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public String getDescription_project() {
        return description_project;
    }

    public void setDescription_project(String description_project) {
        this.description_project = description_project;
    }

    public Date getDate_project() {
        return date_project;
    }

    public void setDate_project(Date date_project) {
        this.date_project = date_project;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }
}
