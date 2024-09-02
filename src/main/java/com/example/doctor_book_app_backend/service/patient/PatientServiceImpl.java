package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Appointment;
import com.example.doctor_book_app_backend.entity.Review;
import com.example.doctor_book_app_backend.repository.AppointmentRepository;
import com.example.doctor_book_app_backend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PatientServiceImpl implements PatientService {
    private final ReviewRepository reviewRepository;
    private final AppointmentRepository appointmentRepository;

    public PatientServiceImpl(ReviewRepository reviewRepository,
                              AppointmentRepository appointmentRepository) {
        this.reviewRepository = reviewRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Review addReview(Review review) {
        review.setDate(new Date());
        return reviewRepository.save(review);
    }

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
