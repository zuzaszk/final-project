package com.backend.zpi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "usos_id", length = 50, unique = true)
    private String usosId;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "alternative_email", length = 50)
    private String alternativeEmail;

    @Column(name = "state")
    private Integer state;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

}
