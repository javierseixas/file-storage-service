package com.javierseixas.test.filerest.infrastructure.controller;

import com.javierseixas.test.filerest.domain.File;
import com.javierseixas.test.filerest.domain.FileRepository;
import com.javierseixas.test.filerest.infrastructure.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class FileController {

    private FileRepository fileRepository;
    private StorageService storageService;

    @Autowired
    public FileController(FileRepository fileRepository, StorageService storageService) {
        this.fileRepository = fileRepository;
        this.storageService = storageService;
    }

    @PostMapping("/files")
    public String handleFileUpload(
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {

        File filee = new File("id", "name", "description", new Date());

        storageService.store(file);
        fileRepository.add(filee);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }
}
