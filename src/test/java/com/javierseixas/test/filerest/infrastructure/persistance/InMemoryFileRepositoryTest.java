package com.javierseixas.test.filerest.infrastructure.persistance;

import com.javierseixas.test.filerest.domain.File;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


public class InMemoryFileRepositoryTest extends TestCase {

    InMemoryFileRepository fileRepository;
    File file;

    public void setUp() throws Exception {
        this.file = new File("My name", "My description", new Date(), "file.txt");
        this.fileRepository = new InMemoryFileRepository();

    }

    public void testReturnFilesWhenThereAre() throws Exception {

        InMemoryFileRepository inMemoryFileRepository = new InMemoryFileRepository(Arrays.asList(file));

        assertThat(inMemoryFileRepository.get(), hasItem(file));
    }

    public void testReturnNotFilesIfThereAreNot() throws Exception {

        assertThat(fileRepository.get(), empty());
    }

    public void testStoreFile() throws Exception {

        fileRepository.add(file);

        assertThat(fileRepository.get(), hasItem(file));
    }
}