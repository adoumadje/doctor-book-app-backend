package com.example.doctor_book_app_backend.service.utils;

import com.example.doctor_book_app_backend.entity.ImageData;
import com.example.doctor_book_app_backend.repository.ImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UtilsService {

    private final ImageDataRepository imageDataRepository;

    @Autowired
    public UtilsService(ImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }

    public String[] toFirstAndLastNames(String fullName) {
        fullName = fullName.trim();
        int i = fullName.indexOf(' ');
        return new  String[]{fullName.substring(0, i),
                fullName.substring(i+1)};
    }

    public String saveProfilePicture(MultipartFile picture) throws IOException {
        String DIR_PATH = "uploads/";
        String path = DIR_PATH + picture.getOriginalFilename();
        ImageData data = imageDataRepository.save(
                ImageData.builder()
                        .name(picture.getOriginalFilename())
                        .path(path)
                        .build()
        );
        picture.transferTo(new File(path));
        return data != null ? data.getPath() : null;
    }
}
