package ru.itis.game.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private Long id;
    private LocalDateTime startGameDateTime;
    private LocalDateTime finishGameDateTime;
    private Player firstPlayer;
    private Player secondPlayer;
    private Integer shotsCount;

}
