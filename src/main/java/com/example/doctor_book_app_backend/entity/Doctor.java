package com.example.doctor_book_app_backend.entity;

import com.example.doctor_book_app_backend.enums.Specialisation;
import com.example.doctor_book_app_backend.general.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@Table(name = "doctor")
public class Doctor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Lob
    @Column(name = "bio")
    private String bio;
    @Lob
    @Column(name = "about")
    private String about;
    @Column(name = "specialisation")
    private Specialisation specialisation;
    @Column(name = "ticket_price")
    private Integer ticketPrice;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Education> educations;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Experience> experiences;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<TimeSlot> timeSlots;
}
