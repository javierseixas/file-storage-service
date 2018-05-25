package com.javierseixas.test.filerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

	private static String UPLOADED_FOLDER = "/home/javierseixas/projects/dotsub/";

	@RequestMapping(value="/", method = RequestMethod.GET)
	public HashMap<Long, File> getSomething(){
		return FileRestApplication.files;
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<?> post(@RequestParam("file") MultipartFile uploadfile) {

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {

			saveUploadedFiles(Arrays.asList(uploadfile));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded - " +
				uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
	}

	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; //next pls
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}
}
