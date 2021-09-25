package ru.itis.manageUsers.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.services.FileService;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * Контроллер для загрузки данных из файла excel
 */
@RestController
public class ExcelController {

    @Autowired
    private FileService fileService;

    /**
     * Метод для згрузки файла
     */
    @ApiOperation(value = "Загрузка excel файла")
    @PermitAll
    @PostMapping(value = "api/excel/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileService.save(file);
    }
}
