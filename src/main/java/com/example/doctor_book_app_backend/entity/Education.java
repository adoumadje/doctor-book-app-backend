package com.example.doctor_book_app_backend.entity;

import com.example.doctor_book_app_backend.general.History;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "education")
public class Education extends History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "degree")
    private String degree;
    @Column(name = "university")
    private String university;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
