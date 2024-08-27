package com.example.doctor_book_app_backend.service.patient;

import com.example.doctor_book_app_backend.entity.Patient;
import com.example.doctor_book_app_backend.repository.PatientRepository;
import com.example.doctor_book_app_backend.request.patient.PatientReq;
import com.example.doctor_book_app_backend.service.utils.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PatientAuthServiceImpl implements PatientAuthService {
    private final PatientRepository patientRepository;
    private final UtilsService utilsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PatientAuthServiceImpl(PatientRepository patientRepository,
                                  UtilsService utilsService,
                                  PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.utilsService = utilsService;
        this.passwordEncoder = passwordEncoder;
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


}
