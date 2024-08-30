package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Patient;
import com.example.doctor_book_app_backend.request.patient.PatientReq;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Map;

public interface PatientAuthService {
    Patient registerPatient(PatientReq patient) throws IOException;

    Map<String, String> logginPatient(Authentication authentication, PatientReq patientReq) throws Exception;
}
