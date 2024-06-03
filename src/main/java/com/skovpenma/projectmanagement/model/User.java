package com.skovpenma.projectmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = User.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    public static final String TABLE_NAME= "users";

    // Getters and Setters
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @NotBlank
    @Column(unique = true)
    private String username;

    @Setter
    @Getter
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @Setter
    @Getter
    @NotBlank
    private String password;

    @Setter
    @Getter
    private String role;

}