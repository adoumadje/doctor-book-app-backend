package com.example.doctor_book_app_backend;

import com.example.doctor_book_app_backend.entity.Admin;
import com.example.doctor_book_app_backend.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DoctorBookAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorBookAppBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AdminRepository adminRepository,
											   PasswordEncoder passwordEncoder) {
		return runner -> {
			createAdmin(adminRepository, passwordEncoder);
		};
	}

	private void createAdmin(AdminRepository adminRepository,
							 PasswordEncoder passwordEncoder) {
		adminRepository.save(new Admin().builder()
				.username("Admin")
				.password(passwordEncoder.encode("AdminPa55"))
				.build());
	}

}
