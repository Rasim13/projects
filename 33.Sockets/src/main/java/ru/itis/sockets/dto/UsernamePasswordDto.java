package ru.itis.sockets.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsernamePasswordDto {
    private String nickname;
    private String password;
    private String type;
}
