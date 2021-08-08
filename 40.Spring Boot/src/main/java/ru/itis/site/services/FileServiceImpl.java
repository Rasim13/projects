package ru.itis.site.services;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.site.models.FileInfo;
import ru.itis.site.repositories.FileInfosRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileInfosRepository filesRepository;

    @Override
    public void save(MultipartFile file) {
        String storageName =
                UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());

        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(file.getOriginalFilename())
                .storageFileName(storageName)
                .size(file.getSize())
                .type(file.getContentType())
                .build();

        try {
            Files.copy(file.getInputStream(), Paths.get("D:\\files", storageName));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        filesRepository.save(fileInfo);
    }
}
