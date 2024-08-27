package com.example.doctor_book_app_backend.repository;

import com.example.doctor_book_app_backend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
