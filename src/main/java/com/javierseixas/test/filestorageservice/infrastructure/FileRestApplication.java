package com.javierseixas.test.filestorageservice.infrastructure;

import com.javierseixas.test.filestorageservice.infrastructure.storage.StorageProperties;
import com.javierseixas.test.filestorageservice.infrastructure.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/files").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
