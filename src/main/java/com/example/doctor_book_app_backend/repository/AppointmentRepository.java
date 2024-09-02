package com.example.doctor_book_app_backend.repository;

import com.example.doctor_book_app_backend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
