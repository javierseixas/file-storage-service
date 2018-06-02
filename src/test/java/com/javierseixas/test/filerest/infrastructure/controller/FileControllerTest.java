package com.javierseixas.test.filerest.infrastructure.controller;

import com.javierseixas.test.filerest.domain.FileRepository;
import com.javierseixas.test.filerest.infrastructure.storage.StorageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(FileController.class)
public class FileControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StorageService storageService;
    @MockBean
    private FileRepository fileRepository;

    @Test
    public void shouldReturnOKifRequestIsCorrect() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "file.txt",
                "text/plain", "Test file".getBytes());

        mvc.perform(multipart("/files")
                .file(multipartFile)
                .param("name", "Nom")
                .param("description", "Descripció"))
            .andExpect(status().is(200));
    }

    @Test
    public void shouldRetrurnBadRequestIfAnyFieldIsMissing() throws Exception {
        mvc.perform(multipart("/files")
                .param("name", "Nom")
                .param("description", "Descripció"))
            .andExpect(status().is(400));

        MockMultipartFile multipartFile = new MockMultipartFile("file", "file.txt",
                "text/plain", "Test file".getBytes());

        mvc.perform(multipart("/files")
                .file(multipartFile)
                .param("name", "Nom"))
            .andExpect(status().is(400));
    }



}
