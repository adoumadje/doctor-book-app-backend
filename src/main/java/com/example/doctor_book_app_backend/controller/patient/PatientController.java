package com.example.doctor_book_app_backend.controller.patient;

import com.example.doctor_book_app_backend.entity.Appointment;
import com.example.doctor_book_app_backend.entity.Review;
import com.example.doctor_book_app_backend.service.patient.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient/")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("add-review")
    public Review addReview(@RequestBody Review review) {
        return patientService.addReview(review);
    }

    @PostMapping("book-appointment")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return patientService.bookAppointment(appointment);
    }
}
