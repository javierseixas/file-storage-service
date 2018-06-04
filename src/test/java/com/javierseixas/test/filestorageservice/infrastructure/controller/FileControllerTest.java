package com.javierseixas.test.filestorageservice.infrastructure.controller;

import com.javierseixas.test.filestorageservice.domain.File;
import com.javierseixas.test.filestorageservice.domain.FileRepository;
import com.javierseixas.test.filestorageservice.infrastructure.storage.StorageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    private  MockMultipartFile multipartFile;

    @Before
    public void setUp() {
        this.multipartFile = new MockMultipartFile("file", "file.txt",
                "text/plain", "Test file".getBytes());
    }

    @Test
    public void shouldReturnOKifRequestIsCorrect() throws Exception {

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

        mvc.perform(multipart("/files")
                .file(multipartFile)
                .param("name", "Nom"))
            .andExpect(status().is(400));
    }

    @Test
    public void shouldReturnOkAndAListOfFiles() throws Exception {

        File file = new File("Nom", "Descripció", new Date(), "file.txt");

        List<File> files = Arrays.asList(file);

        given(fileRepository.get()).willReturn(files);

        mvc.perform(get("/files"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(1)));
    }



}
