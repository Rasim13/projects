package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.site.dto.FileUrlDto;
import ru.itis.site.services.FileService;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesController {

    @Autowired
    private FileService fileService;

    @PermitAll
    @GetMapping("/files/upload")
    public String getFileUploadPage() {
        return "file_upload";
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        fileService.writeFileToResponse(fileName, response);
    }

    @PermitAll
    @PostMapping("/files")
    @ResponseBody
    public FileUrlDto saveFile(@RequestParam("file") MultipartFile file) {
        return fileService.save(file);

    }
}
