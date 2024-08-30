package com.example.doctor_book_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DoctorBookAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorBookAppBackendApplication.class, args);
	}

}
