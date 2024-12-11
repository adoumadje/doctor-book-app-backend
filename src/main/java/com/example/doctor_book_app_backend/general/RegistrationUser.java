package com.example.doctor_book_app_backend.general;

import com.example.doctor_book_app_backend.enums.Gender;
import lombok.Data;

@Data
public class RegistrationUser {
    private String fullname;
    private String email;
    private String password;
    private Gender gender;
    private String profilePicUrl;
}
