package com.example.doctor_book_app_backend.request.doctor;

import com.example.doctor_book_app_backend.entity.Education;
import com.example.doctor_book_app_backend.entity.Experience;
import com.example.doctor_book_app_backend.entity.TimeSlot;
import com.example.doctor_book_app_backend.enums.Specialisation;
import com.example.doctor_book_app_backend.general.RegistrationUser;
import lombok.Data;

import java.util.List;


@Data
public class DoctorReq extends RegistrationUser {
    private String phoneNumber;
    private String bio;
    private String about;
    private Specialisation specialisation;
    private Integer ticketPrice;
    List<Education> educations;
    List<Experience> experiences;
    List<TimeSlot> timeSlots;
}
