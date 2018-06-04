package com.javierseixas.test.filestorageservice.infrastructure.controller;

import com.javierseixas.test.filestorageservice.domain.File;
import com.javierseixas.test.filestorageservice.domain.FileRepository;
import com.javierseixas.test.filestorageservice.infrastructure.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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

        File fileRecord = new File(name, description, new Date(), file.getOriginalFilename());

        storageService.store(file);
        fileRepository.add(fileRecord);

        return fileRecord;
    }

    @GetMapping("/files")
    public Collection<File> handleFilesRetrieving() {
        return fileRepository.get();
    }
}
