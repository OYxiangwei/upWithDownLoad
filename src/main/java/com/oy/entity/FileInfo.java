package com.oy.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class FileInfo implements Serializable {
    private static final long serialVersionUIDl=1L;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
