package ru.itis.manageUsers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.models.User;
import ru.itis.manageUsers.services.FileService;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController("/api/excel")
public class ExcelController {

    @Autowired
    private FileService fileService;

    @PermitAll
    @PostMapping(value = "/upload")
    public List<UserDto> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileService.save(file);
    }
}
