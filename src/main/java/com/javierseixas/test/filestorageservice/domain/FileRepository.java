package com.javierseixas.test.filestorageservice.domain;

import java.util.Collection;

public interface FileRepository {

    Collection<File> get();

    void add(File file);

}
