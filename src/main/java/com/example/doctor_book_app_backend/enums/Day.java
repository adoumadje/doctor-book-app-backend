package com.example.doctor_book_app_backend.enums;

import lombok.Getter;

@Getter
public enum Day {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String value;

    private Day(String value) {
        this.value = value;
    }

}
