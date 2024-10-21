package com.backend.zpi.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column(unique = true, nullable = false)
    private String usosId;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String name;
    
    private String alternativeEmail;
    
    private int state;
    
    private Timestamp createdAt;
    
    private Timestamp lastLoginAt;
    
    private Timestamp lastUpdatedAt;
}
