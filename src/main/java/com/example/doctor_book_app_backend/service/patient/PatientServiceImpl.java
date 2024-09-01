package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Review;
import com.example.doctor_book_app_backend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PatientServiceImpl implements PatientService {
    private final ReviewRepository reviewRepository;

    public PatientServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(Review review) {
        review.setDate(new Date());
        return reviewRepository.save(review);
    }
}
