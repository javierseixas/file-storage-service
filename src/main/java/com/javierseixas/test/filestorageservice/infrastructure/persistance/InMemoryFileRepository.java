package com.javierseixas.test.filestorageservice.infrastructure.persistance;

import com.javierseixas.test.filestorageservice.domain.File;
import com.javierseixas.test.filestorageservice.domain.FileRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class InMemoryFileRepository implements FileRepository {

    private Collection<File> files;

    public InMemoryFileRepository(Collection<File> files) {
        this.files = files;
    }

    public InMemoryFileRepository() {
        files = new ArrayList<>();
    }

    @Override
    public Collection<File> get () {
        return files;
    }

    @Override
    public void add (File file){
        files.add(file);
    }
}
