package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Appointment;
import com.example.doctor_book_app_backend.entity.Review;
import com.example.doctor_book_app_backend.entity.Testimony;

public interface PatientService {
    Review addReview(Review review);

    Appointment bookAppointment(Appointment appointment);

    Testimony sendFeedback(Testimony testimony);
}
