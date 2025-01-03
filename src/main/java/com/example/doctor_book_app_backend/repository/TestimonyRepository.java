package com.example.doctor_book_app_backend.repository;

import com.example.doctor_book_app_backend.entity.Testimony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonyRepository extends JpaRepository<Testimony, Long> {
}
