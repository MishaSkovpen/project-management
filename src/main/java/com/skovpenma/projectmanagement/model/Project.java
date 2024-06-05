package com.skovpenma.projectmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Project {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @NotBlank
    private String name;

    @Setter
    @Getter
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    // Getters and Setters
}