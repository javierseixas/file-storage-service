package com.javierseixas.test.filerest.infrastructure;

import com.javierseixas.test.filerest.infrastructure.storage.StorageProperties;
import com.javierseixas.test.filerest.infrastructure.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(FileRestApplication.class, args);
	}


    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
