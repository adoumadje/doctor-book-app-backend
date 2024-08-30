package com.example.doctor_book_app_backend.controller.doctor;

import com.example.doctor_book_app_backend.entity.Doctor;
import com.example.doctor_book_app_backend.request.doctor.DoctorReq;
import com.example.doctor_book_app_backend.service.doctor.DoctorAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorAuthController {
    private final DoctorAuthService doctorAuthService;

    public DoctorAuthController(DoctorAuthService doctorAuthService) {
        this.doctorAuthService = doctorAuthService;
    }

    @PostMapping("/register-doctor")
    public Doctor registerDoctor(@RequestBody DoctorReq doctorReq) throws IOException {
        return doctorAuthService.registerDoctor(doctorReq);
    }

    @PostMapping("/loggin-doctor")
    public Map<String, String> logginDoctor(Authentication authentication,
                                            @RequestBody DoctorReq doctorReq) throws Exception {
        return doctorAuthService.logginDoctor(authentication, doctorReq);
    }
}
