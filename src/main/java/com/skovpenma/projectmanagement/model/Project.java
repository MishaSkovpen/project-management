package com.skovpenma.projectmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    // Getters and Setters
}