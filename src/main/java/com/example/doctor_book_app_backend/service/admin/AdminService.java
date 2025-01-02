package com.example.doctor_book_app_backend.service.admin;

import com.example.doctor_book_app_backend.entity.FAQs;
import org.springframework.security.core.Authentication;

public interface AdminService {
    FAQs addFAQs(FAQs faqs);

    String loginAdmin(Authentication authentication);
}
