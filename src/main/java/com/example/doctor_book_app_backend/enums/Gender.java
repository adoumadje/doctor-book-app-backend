package com.example.doctor_book_app_backend.enums;


import lombok.Getter;

@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String value;

    private Gender(String value) {
        this.value = value;
    }

}
