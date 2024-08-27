package com.example.doctor_book_app_backend.general;

import com.example.doctor_book_app_backend.enums.Gender;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RegistrationUser {
    private String fullName;
    private String email;
    private String password;
    private Gender gender;
    private String profilePicUrl;
    private MultipartFile profilePicture;
}
