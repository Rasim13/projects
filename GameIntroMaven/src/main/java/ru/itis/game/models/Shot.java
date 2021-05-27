package ru.itis.game.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shot {
    private Long id;
    private Player shooter;
    private Player target;
    private Game game;
}
