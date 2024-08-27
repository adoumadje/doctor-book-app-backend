package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Patient;
import com.example.doctor_book_app_backend.request.patient.PatientReq;

import java.io.IOException;

public interface PatientAuthService {
    Patient registerPatient(PatientReq patient) throws IOException;

    Patient logginPatient(PatientReq patientReq) throws Exception;
}
