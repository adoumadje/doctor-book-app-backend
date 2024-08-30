package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Patient;
import com.example.doctor_book_app_backend.repository.PatientRepository;
import com.example.doctor_book_app_backend.request.patient.PatientReq;
import com.example.doctor_book_app_backend.service.utils.TokenService;
import com.example.doctor_book_app_backend.service.utils.UtilsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PatientAuthServiceImpl implements PatientAuthService {
    private final PatientRepository patientRepository;
    private final UtilsService utilsService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Autowired
    public PatientAuthServiceImpl(PatientRepository patientRepository,
                                  UtilsService utilsService,
                                  PasswordEncoder passwordEncoder,
                                  TokenService tokenService) {
        this.patientRepository = patientRepository;
        this.utilsService = utilsService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public Patient registerPatient(PatientReq patientReq) throws IOException {
        String[] firstLast = utilsService.toFirstAndLastNames(patientReq.getFullName());
        if(patientReq.getProfilePicture() != null) {
            patientReq.setProfilePicUrl(
                    utilsService.saveProfilePicture(
                            patientReq.getProfilePicture()));
        }
        return patientRepository.save(Patient.builder()
                .firstName(firstLast[0])
                .lastName(firstLast[1])
                .email(patientReq.getEmail())
                .password(
                        passwordEncoder.encode(patientReq.getPassword())
                )
                .gender(patientReq.getGender())
                .profilePicUrl(patientReq.getProfilePicUrl())
                .bloodGroup(patientReq.getBloodGroup())
                .build());
    }

    @Override
    public Map<String, String> logginPatient(Authentication authentication,
                                             PatientReq patientReq) throws Exception {
        Patient patient = patientRepository.findByEmail(patientReq.getEmail());
        if(patient == null) {
            throw new RuntimeException("Invalid email");
        }
        if(!passwordEncoder.matches(patientReq.getPassword(), patient.getPassword())) {
            throw new Exception("Invalid password");
        }
        Map<String, String> response = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        response.put("patient", objectMapper.writeValueAsString(patient));
        response.put("token", tokenService.generateToken(authentication));
        return response;
    }


}
