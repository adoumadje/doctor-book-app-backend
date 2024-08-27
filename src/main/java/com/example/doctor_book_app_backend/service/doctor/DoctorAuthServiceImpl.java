package com.example.doctor_book_app_backend.service.doctor;

import com.example.doctor_book_app_backend.entity.Doctor;
import com.example.doctor_book_app_backend.repository.DoctorRepository;
import com.example.doctor_book_app_backend.request.doctor.DoctorReq;
import com.example.doctor_book_app_backend.service.utils.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DoctorAuthServiceImpl implements DoctorAuthService {
    private final DoctorRepository doctorRepository;
    private final UtilsService utilsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DoctorAuthServiceImpl(DoctorRepository doctorRepository,
                                 UtilsService utilsService,
                                 PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.utilsService = utilsService;
        this.passwordEncoder = passwordEncoder;
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
                .educations(doctorReq.getEducations())
                .experiences(doctorReq.getExperiences())
                .timeSlots(doctorReq.getTimeSlots())
                .build());
    }
}
