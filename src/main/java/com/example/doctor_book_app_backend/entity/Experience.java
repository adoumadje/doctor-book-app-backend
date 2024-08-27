package com.example.doctor_book_app_backend.entity;

import com.example.doctor_book_app_backend.general.History;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "experience")
public class Experience extends History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "position")
    private String position;
    @Column(name = "company")
    private String company;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
