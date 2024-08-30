package com.example.doctor_book_app_backend.entity;

import com.example.doctor_book_app_backend.enums.Specialisation;
import com.example.doctor_book_app_backend.general.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "doctor")
public class Doctor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "bio")
    private String bio;
    @Lob
    @Basic(fetch = FetchType.EAGER)
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
