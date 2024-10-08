package com.example.doctor_book_app_backend.enums;

import lombok.Getter;

@Getter
public enum Specialisation {
    DENTIST("Dentist"),
    CARDIOLOGIST("Cardiologist"),
    ORTHOPEDIST("Orthopedist"),
    OTOLOGIST("Otologist"),
    NEUROLOGIST("Neurologist"),
    GENERAL_DOCTOR("General Doctor"),
    SURGEON("Surgeon"),
    PSYCHOTHERAPIST("Psychotherapist"),
    EYE_SPECIALIST("Eye Specialist");

    private final String value;

    private Specialisation(String value) {
        this.value = value;
    }

}
