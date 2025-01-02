package com.example.doctor_book_app_backend.service.admin;

import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.repository.FAQsRepository;
import org.springframework.security.core.Authentication;


public class AdminServiceImpl implements AdminService {
    private final FAQsRepository faqsRepository;

    public AdminServiceImpl(FAQsRepository faqsRepository) {
        this.faqsRepository = faqsRepository;
    }

    @Override
    public FAQs addFAQs(FAQs faq) {
        return faqsRepository.save(faq);
    }

    @Override
    public String loginAdmin(Authentication authentication) {
        return null;
    }
}
