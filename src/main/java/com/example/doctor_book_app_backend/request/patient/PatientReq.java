package com.example.doctor_book_app_backend.request.patient;

import com.example.doctor_book_app_backend.enums.BloodGroup;
import com.example.doctor_book_app_backend.general.RegistrationUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class PatientReq extends RegistrationUser {
    private BloodGroup bloodGroup;
}