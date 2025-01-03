package com.example.doctor_book_app_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "testimony")
@Data
@ToString
public class Testimony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "testimony")
    private String testimony;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
