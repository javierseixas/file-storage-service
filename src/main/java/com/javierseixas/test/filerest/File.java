package com.javierseixas.test.filerest;

public class File {

    private String uuid;
    private String name;

    public File(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
