package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.site.services.FileService;

import javax.annotation.security.PermitAll;

@Controller
public class FilesController {

    @Autowired
    private FileService fileService;

    @PermitAll
    @GetMapping("/files/upload")
    public String getFileUploadPage() {
        return "file_upload";
    }

    @PermitAll
    @PostMapping("/files")
    public String saveFile(@RequestParam("file") MultipartFile file) {
        fileService.save(file);
        return "file_upload";
    }
}
