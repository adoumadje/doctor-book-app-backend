package com.example.doctor_book_app_backend.controller;


import com.example.doctor_book_app_backend.service.utils.UtilsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/general/")
public class GeneralController {
    private final UtilsService utilsService;

    public GeneralController(UtilsService utilsService) {
        this.utilsService = utilsService;
    }

    @PostMapping("upload-profile-pic")
    public String uploadProfilePic(@RequestParam("file")MultipartFile file,
                                   HttpServletRequest request
    ) throws IOException {
        String protocol = request.getProtocol();
        String host = request.getServerName();
        int port = request.getServerPort();

        String baseUrl = protocol + "://" + host + ":" + port;

        return baseUrl + "/uploads/" + utilsService.saveProfilePicture(file);
    }
}
