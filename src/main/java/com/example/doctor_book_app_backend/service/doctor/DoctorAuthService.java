package com.example.doctor_book_app_backend.service.doctor;

import com.example.doctor_book_app_backend.entity.Doctor;
import com.example.doctor_book_app_backend.request.doctor.DoctorReq;

import java.io.IOException;

public interface DoctorAuthService {
    Doctor registerDoctor(DoctorReq doctorReq) throws IOException;
}
