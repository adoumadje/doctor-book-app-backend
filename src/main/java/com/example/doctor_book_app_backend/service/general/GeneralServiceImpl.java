package com.example.doctor_book_app_backend.service.general;

import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.repository.FAQsRepository;

import java.util.List;

public class GeneralServiceImpl implements GeneralService {

    private final FAQsRepository faqsRepository;

    public GeneralServiceImpl(FAQsRepository faqsRepository) {
        this.faqsRepository = faqsRepository;
    }

    @Override
    public List<FAQs> getFAQs() {
        return faqsRepository.findAll();
    }
}
