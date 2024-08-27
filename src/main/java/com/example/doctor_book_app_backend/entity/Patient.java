package com.example.doctor_book_app_backend.entity;

import com.example.doctor_book_app_backend.enums.BloodGroup;
import com.example.doctor_book_app_backend.enums.Gender;
import com.example.doctor_book_app_backend.general.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Patient extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "blood_group")
    private BloodGroup bloodGroup;
}
