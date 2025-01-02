package com.example.doctor_book_app_backend.controller.admin;

import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.service.admin.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("login-admin")
    public String loginAdmin(Authentication authentication) {
        return adminService.loginAdmin(authentication);
    }
    @PostMapping("/add-FAQs")
    public FAQs addFAQs(@RequestBody FAQs faq) {
        return adminService.addFAQs(faq);
    }
}
