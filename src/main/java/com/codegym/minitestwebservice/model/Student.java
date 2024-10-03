package com.codegym.minitestwebservice.model;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;

    private Double mark;
    private String img;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private StudentClass studentClass;


}

