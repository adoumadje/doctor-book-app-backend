package com.example.doctor_book_app_backend.service.general;

import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.entity.Testimony;
import com.example.doctor_book_app_backend.repository.FAQsRepository;
import com.example.doctor_book_app_backend.repository.TestimonyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralServiceImpl implements GeneralService {

    private final FAQsRepository faqsRepository;
    private final TestimonyRepository testimonyRepository;

    public GeneralServiceImpl(FAQsRepository faqsRepository,
                              TestimonyRepository testimonyRepository) {
        this.faqsRepository = faqsRepository;
        this.testimonyRepository = testimonyRepository;
    }

    @Override
    public List<FAQs> getFAQs() {
        return faqsRepository.findAll();
    }

    @Override
    public List<Testimony> loadTestimonials() {
        return testimonyRepository.findAll();
    }
}
