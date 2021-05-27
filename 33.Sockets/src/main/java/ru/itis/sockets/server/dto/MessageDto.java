package ru.itis.sockets.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// DTO - DataTransferObject - это классы, объекты которого используется для передачи данных между системами
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MessageDto {
    private String text;
    private String from;
    private LocalDateTime dispatchDateTime;

    @JsonInclude(JsonInclude.Include.NON_NULL) // данная аннотация позволяет не передавать null
    List<String> tags;

}
