package ru.itis.repositories;

import ru.itis.models.Game;
import ru.itis.models.Player;
import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class GamesRepositoryFileBasedImpl implements GamesRepository{

    private String fileName;

    public GamesRepositoryFileBasedImpl(String fileName) {
        this.fileName = fileName;
    }

    private Mapper<Game, String> gameToStringLineMapper = game -> {
        StringBuilder line = new StringBuilder();
        line.append(game.getId())
                .append("|")
                .append(game.getStartGameDateTime().toString())
                .append("|");

        if(game.getFinishGameDateTime() == null) {
            line.append("NULL")
                 .append("|");
        } else {
            line.append(game.getFinishGameDateTime())
            .append("|");
        }

        line.append(game.getFirstPlayer().getNickname())
                .append("|")
                .append(game.getSecondPlayer().getNickname())
                .append("|");
        if (game.getShotsCount() == null) {
            line.append("NULL")
                    .append("|");
        } else {
            line.append(game.getShotsCount())
                    .append("|");
        }
        return line.toString();
    };

    private Mapper<String, Game> stringLineToGameMapper = line -> {
        Game game = new Game();
        String[] parsedLine = line.split("\\|");
        game.setId(parsedLine[0]);
        game.setStartGameDateTime(LocalDateTime.parse(parsedLine[1]));
        if (parsedLine[2].equals("NULL")) {
            game.setFinishGameDateTime(null);
        } else {
            game.setFinishGameDateTime(LocalDateTime.parse(parsedLine[2]));
        }
        game.setFirstPlayer(new Player(parsedLine[3]));
        game.setSecondPlayer(new Player(parsedLine[4]));

        if (parsedLine[5].equals("NULL")) {
            game.setShotsCount(null);
        } else {
            game.setShotsCount(Integer.parseInt(parsedLine[5]));
        }

        return game;
    };


    @Override
    public void save(Game game) {
        String lineToSave = gameToStringLineMapper.map(game);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(lineToSave + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Game findOneById(String gameId) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String lineFromFile = reader.readLine();
            while(lineFromFile != null) {
                Game game = stringLineToGameMapper.map(lineFromFile);
                if (game.getId().equals(gameId)) {
                    return game;
                }
                lineFromFile = reader.readLine();
            }

            return null;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Game game) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            List<Game> gamesFromFile = reader.lines()// получаем все строки из файла
                    .map(stringLineToGameMapper::map) //преобразовали все в список
                    .collect(Collectors.toList());

            Game gameFromFile = gamesFromFile.stream()
                    .filter(existedGame -> existedGame.getId().equals(game.getId())) // находим все игры с нужным id
                    .limit(1) // ограничиваем выборку до 1 - го элемента
                    .collect(Collectors.toList()) // преобразуем в список
                    .get(0); // возьмем первый элемент

            gameFromFile.setFinishGameDateTime(game.getFinishGameDateTime());
            gamesFromFile.removeIf(existedGame -> existedGame.getId().equals(gameFromFile.getId()));
            gamesFromFile.add(gameFromFile);
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            gamesFromFile.forEach(newGame -> {
                try {
                    writer.write(gameToStringLineMapper.map(newGame) + "\n");
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            });
            writer.close();

            gamesFromFile = gamesFromFile.stream()
                    .map(existedGame -> {
                        if (existedGame.getId().equals(gameFromFile.getId())) {
                            return gameFromFile;
                        } else {
                            return existedGame;
                        }
                    }).collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
