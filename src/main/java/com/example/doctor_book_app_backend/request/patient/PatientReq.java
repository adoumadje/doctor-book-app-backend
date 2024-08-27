package com.example.doctor_book_app_backend.request.patient;

import com.example.doctor_book_app_backend.enums.BloodGroup;
import com.example.doctor_book_app_backend.general.RegistrationUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PatientReq extends RegistrationUser {
    private BloodGroup bloodGroup;
}