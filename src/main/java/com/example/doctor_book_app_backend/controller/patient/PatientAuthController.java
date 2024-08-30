package com.example.doctor_book_app_backend.controller.patient;

import com.example.doctor_book_app_backend.entity.Patient;
import com.example.doctor_book_app_backend.request.patient.PatientReq;
import com.example.doctor_book_app_backend.service.patient.PatientAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patient/")
public class PatientAuthController {
    private final PatientAuthService authService;

    @Autowired
    public PatientAuthController(PatientAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-patient")
    public Patient registerPatient(@RequestBody PatientReq patient) throws IOException {
        return authService.registerPatient(patient);
    }

    @PostMapping("/loggin-patient")
    public Map<String, String> logginPatient(Authentication authentication,
                                             @RequestBody PatientReq patientReq) throws Exception {
        return authService.logginPatient(authentication, patientReq);
    }
}
