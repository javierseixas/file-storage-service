package com.javierseixas.test.filerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
public class FileRestApplication {

	public static HashMap<Long, File> files;

	public static void main(String[] args) {

		files = new HashMap<Long, File>();
		SpringApplication.run(FileRestApplication.class, args);

		File file = new File("pepe", "pepito");
		files.put(1L, file);

	}
}

@RestController
@RequestMapping(value="/api/files")
class FileService{

	@RequestMapping(value="/", method = RequestMethod.GET)
	public HashMap<Long, File> getSomething(){
		return FileRestApplication.files;
	}
}
