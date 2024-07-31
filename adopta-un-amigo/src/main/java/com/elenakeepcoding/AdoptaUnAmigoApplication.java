package com.elenakeepcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.elenakeepcoding")
@EnableJpaRepositories(basePackages = "com.elenakeepcoding.repository")
public class AdoptaUnAmigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptaUnAmigoApplication.class, args);
	}

}
