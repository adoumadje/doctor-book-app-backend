package com.example.doctor_book_app_backend.general;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class History {
    @Column(name = "starting_date")
    private Date startingDate;
    @Column(name = "ending_date")
    private Date endingDate;
}
