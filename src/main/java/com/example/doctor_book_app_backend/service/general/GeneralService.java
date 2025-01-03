package com.example.doctor_book_app_backend.service.general;

import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.entity.Testimony;

import java.util.List;

public interface GeneralService {
    List<FAQs> getFAQs();

    List<Testimony> loadTestimonials();
}
