package com.example.doctor_book_app_backend.controller;


import com.example.doctor_book_app_backend.entity.FAQs;
import com.example.doctor_book_app_backend.service.admin.AdminService;
import com.example.doctor_book_app_backend.service.general.GeneralService;
import com.example.doctor_book_app_backend.service.utils.UtilsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/general/")
public class GeneralController {
    private final UtilsService utilsService;
    private final AdminService adminService;
    private final GeneralService generalService;

    public GeneralController(UtilsService utilsService,
                             AdminService adminService,
                             GeneralService generalService) {
        this.utilsService = utilsService;
        this.adminService = adminService;
        this.generalService = generalService;
    }

    @PostMapping("upload-profile-pic")
    public String uploadProfilePic(@RequestParam("file")MultipartFile file,
                                   HttpServletRequest request
    ) throws IOException {
        return utilsService.saveProfilePicture(file);
    }

    @PostMapping("add-QA")
    public FAQs addQA(@RequestBody FAQs faq) {
        return adminService.addFAQs(faq);
    }

    @GetMapping("get-FAQs")
    public List<FAQs> getFAQs() {
        return generalService.getFAQs();
    }
}
