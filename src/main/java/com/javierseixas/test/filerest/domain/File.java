package com.javierseixas.test.filerest.domain;

import java.util.Date;

public class File {

    private String uuid;
    private String name;
    private String description;
    private Date creationDate;

    public File(String uuid, String name, String description, Date creationDate) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
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
}
