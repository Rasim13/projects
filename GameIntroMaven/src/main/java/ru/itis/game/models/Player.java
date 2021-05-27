package ru.itis.game.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private Long id;
    private String nickname;
    private String password;
    private Integer score;
    private Integer winsCount;
    private Integer losesCount;
}
