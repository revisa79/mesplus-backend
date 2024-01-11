package io.paradigm.mesplusbackend;

import io.paradigm.mesplusbackend.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class MesplusBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesplusBackendApplication.class, args);
	}

}
