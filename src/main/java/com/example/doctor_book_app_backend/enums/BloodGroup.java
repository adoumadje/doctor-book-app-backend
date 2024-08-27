package com.example.doctor_book_app_backend.enums;

import lombok.Getter;

@Getter
public enum BloodGroup {
    A_POS("A+"),
    A_NEG("A-"),
    B_POS("B+"),
    B_NEG("B-"),
    O_POS("O+"),
    O_NEG("O-"),
    AB_POS("AB+"),
    AB_NEG("AB-");

    private final String value;

    private BloodGroup(String value) {
        this.value = value;
    }

}
