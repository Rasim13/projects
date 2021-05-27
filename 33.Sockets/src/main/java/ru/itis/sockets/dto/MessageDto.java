package ru.itis.sockets.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MessageDto {
    private String text;
    private String from;
    private LocalDateTime dispatchDateTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<String> tags;
}
