package com.javierseixas.test.filerest.infrastructure.controller;

import com.javierseixas.test.filerest.domain.File;
import com.javierseixas.test.filerest.domain.FileRepository;
import com.javierseixas.test.filerest.infrastructure.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@RestController
public class FileController {

    private FileRepository fileRepository;
    private StorageService storageService;

    @Autowired
    public FileController(FileRepository fileRepository, StorageService storageService) {
        this.fileRepository = fileRepository;
        this.storageService = storageService;
    }

    @PostMapping("/files")
    public File handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            RedirectAttributes redirectAttributes
    ) {

        File fileRecord = new File(name, description, new Date());

        storageService.store(file);
        fileRepository.add(fileRecord);

        return fileRecord;
    }
}
