package com.example.doctor_book_app_backend.entity;

import com.example.doctor_book_app_backend.enums.Day;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "time_slot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "day")
    private Day day;
    @Column(name = "starting_time")
    private LocalTime startingTime;
    @Column(name = "ending_time")
    private LocalTime endingTime;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
