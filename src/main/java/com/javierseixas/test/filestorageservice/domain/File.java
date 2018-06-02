package com.javierseixas.test.filestorageservice.domain;

import java.util.Date;
import java.util.UUID;

public class File {

    private String uuid;
    private String name;
    private String description;
    private Date creationDate;
    private String path;

    public File(String name, String description, Date creationDate, String path) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.path = path;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getPath() {
        return path;
    }
}
