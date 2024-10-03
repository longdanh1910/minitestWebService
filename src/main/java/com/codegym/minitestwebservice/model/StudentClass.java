package com.codegym.minitestwebservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "class")
@Data
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}

