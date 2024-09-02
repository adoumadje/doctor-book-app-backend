package com.example.doctor_book_app_backend.service.doctor;

import com.example.doctor_book_app_backend.entity.Doctor;
import com.example.doctor_book_app_backend.enums.Status;
import com.example.doctor_book_app_backend.repository.DoctorRepository;
import com.example.doctor_book_app_backend.request.doctor.DoctorReq;
import com.example.doctor_book_app_backend.service.utils.TokenService;
import com.example.doctor_book_app_backend.service.utils.UtilsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
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
public class DoctorAuthServiceImpl implements DoctorAuthService {
    private final DoctorRepository doctorRepository;
    private final UtilsService utilsService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Autowired
    public DoctorAuthServiceImpl(DoctorRepository doctorRepository,
                                 UtilsService utilsService,
                                 PasswordEncoder passwordEncoder,
                                 TokenService tokenService) {
        this.doctorRepository = doctorRepository;
        this.utilsService = utilsService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public Doctor registerDoctor(DoctorReq doctorReq) throws IOException {
        if(doctorReq.getProfilePicture() != null) {
            doctorReq.setProfilePicUrl(
                    utilsService.saveProfilePicture(
                            doctorReq.getProfilePicture()
                    )
            );
        }
        String[] firstLast = utilsService.toFirstAndLastNames(
                doctorReq.getFullName()
        );
        return doctorRepository.save(Doctor.builder()
                .firstName(firstLast[0])
                .lastName(firstLast[1])
                .email(doctorReq.getEmail())
                .password(
                        passwordEncoder.encode(doctorReq.getPassword())
                )
                .gender(doctorReq.getGender())
                .profilePicUrl(doctorReq.getProfilePicUrl())
                .phoneNumber(doctorReq.getPhoneNumber())
                .bio(doctorReq.getBio())
                .about(doctorReq.getAbout())
                .specialisation(doctorReq.getSpecialisation())
                .ticketPrice(doctorReq.getTicketPrice())
                .status(Status.PENDING)
                .educations(doctorReq.getEducations())
                .experiences(doctorReq.getExperiences())
                .timeSlots(doctorReq.getTimeSlots())
                .build());
    }

    @Override
    @Transactional
    public Map<String, String> logginDoctor(Authentication authentication,
                                            DoctorReq doctorReq) throws Exception {
        Doctor doctor = doctorRepository.findByEmail(doctorReq.getEmail());
        log.info("doctor = " + doctor.toString());
        if(doctor == null) {
            throw new RuntimeException("Invalid email");
        }
        if(!passwordEncoder.matches(doctorReq.getPassword(), doctor.getPassword())) {
            throw new Exception("Invalid password");
        }
        Map<String, String> response = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        response.put("doctor", objectMapper.writeValueAsString(doctor));
        response.put("token", tokenService.generateToken(authentication));
        return response;
    }
}
