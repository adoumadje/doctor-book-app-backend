package com.example.doctor_book_app_backend.service.utils;

import com.example.doctor_book_app_backend.repository.ImageDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class UtilsService {

    private final ImageDataRepository imageDataRepository;
    private final String DIR_PATH = "C:\\Users\\adoum\\Documents\\Portfolio Projects" +
            "\\Doctor Booking App\\doctor-book-app-backend\\src\\main\\resources\\static\\uploads\\";

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
        File directory = new File(DIR_PATH);
        if(!directory.exists()) {
            directory.mkdirs();
        }
        String path = DIR_PATH + picture.getOriginalFilename();
        picture.transferTo(new File(path));
        return picture.getOriginalFilename();
    }
}
