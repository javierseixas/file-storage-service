package com.javierseixas.test.filerest.infrastructure.persistance;

import com.javierseixas.test.filerest.domain.File;
import com.javierseixas.test.filerest.domain.FileRepository;
import org.springframework.stereotype.Service;

@Service
public class InMemoryFileRepository implements FileRepository {

    @Override
    public void get() {

    }

    @Override
    public void add(File file) {

    }
}
