package com.example.doctor_book_app_backend.service.utils;

import com.example.doctor_book_app_backend.general.User;
import com.example.doctor_book_app_backend.general.UserPrincipal;
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

    public MyUserDetailsService(DoctorRepository doctorRepository,
                                PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = patientRepository.findByEmail(username);
        if(user == null) {
            user = doctorRepository.findByEmail(username);
        }
        if(user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
