package ru.itis.site.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void save (MultipartFile file);
}
