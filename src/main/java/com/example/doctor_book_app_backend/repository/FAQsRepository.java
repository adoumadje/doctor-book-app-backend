package com.example.doctor_book_app_backend.repository;

import com.example.doctor_book_app_backend.entity.FAQs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQsRepository extends JpaRepository<FAQs, Long> {
    FAQs findByQuestion(String question);
}
