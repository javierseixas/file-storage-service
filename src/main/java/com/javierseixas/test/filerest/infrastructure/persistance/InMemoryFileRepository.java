package com.javierseixas.test.filerest.infrastructure.persistance;

import com.javierseixas.test.filerest.domain.File;
import com.javierseixas.test.filerest.domain.FileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class InMemoryFileRepository implements FileRepository {

    private final Collection<File> files = new ArrayList<>();

    @Override
    public Collection<File> get() {
        return files;
    }

    @Override
    public void add(File file) {
        files.add(file);
    }
}
