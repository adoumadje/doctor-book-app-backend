package com.example.doctor_book_app_backend.service.doctor;

import com.example.doctor_book_app_backend.entity.Doctor;
import com.example.doctor_book_app_backend.request.doctor.DoctorReq;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Map;

public interface DoctorAuthService {
    Doctor registerDoctor(DoctorReq doctorReq) throws IOException;

    Map<String, String> logginDoctor(Authentication authentication, DoctorReq doctorReq) throws Exception;
}
