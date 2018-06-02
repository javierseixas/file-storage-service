package com.javierseixas.test.filerest.domain;

import java.util.Collection;

public interface FileRepository {

    Collection<File> get();

    void add(File file);

}
