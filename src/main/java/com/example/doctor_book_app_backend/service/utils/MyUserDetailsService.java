package com.example.doctor_book_app_backend.service.utils;

import com.example.doctor_book_app_backend.entity.Admin;
import com.example.doctor_book_app_backend.general.User;
import com.example.doctor_book_app_backend.general.UserPrincipal;
import com.example.doctor_book_app_backend.repository.AdminRepository;
import com.example.doctor_book_app_backend.repository.DoctorRepository;
import com.example.doctor_book_app_backend.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AdminRepository adminRepository;

    public MyUserDetailsService(DoctorRepository doctorRepository,
                                PatientRepository patientRepository,
                                AdminRepository adminRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = patientRepository.findByEmail(username);
        if(user == null) {
            user = doctorRepository.findByEmail(username);
        }
        if(user == null) {
            Admin admin = adminRepository.findByUsername(username);
            if (admin == null) {
                throw new UsernameNotFoundException("user not found");
            }
            user = new User().builder()
                    .email(admin.getUsername())
                    .password(admin.getPassword())
                    .build();
        }
        return new UserPrincipal(user);
    }
}
