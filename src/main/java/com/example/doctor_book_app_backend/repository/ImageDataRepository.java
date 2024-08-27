package com.example.doctor_book_app_backend.repository;

import com.example.doctor_book_app_backend.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
}
