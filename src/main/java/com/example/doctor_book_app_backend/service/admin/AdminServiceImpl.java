package com.example.doctor_book_app_backend.service.admin;

import com.example.doctor_book_app_backend.entity.Admin;
import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.repository.AdminRepository;
import com.example.doctor_book_app_backend.repository.FAQsRepository;
import com.example.doctor_book_app_backend.service.utils.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
    private final FAQsRepository faqsRepository;
    private final AdminRepository adminRepository;
    private final TokenService tokenService;

    public AdminServiceImpl(FAQsRepository faqsRepository,
                            AdminRepository adminRepository,
                            TokenService tokenService) {
        this.faqsRepository = faqsRepository;
        this.adminRepository = adminRepository;
        this.tokenService = tokenService;
    }

    @Override
    public FAQs addFAQs(FAQs faq) {
        return faqsRepository.save(faq);
    }

    @Override
    public String loginAdmin(Authentication authentication) {
        Admin admin = adminRepository.findByUsername(authentication.getName());
        if(admin == null) {
            throw new RuntimeException("Admin not found");
        }
        return tokenService.generateToken(authentication);
    }
}
