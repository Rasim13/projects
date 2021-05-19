package ru.itis.game.services;

import java.util.Random;

public class GameLogicServiceRandomImpl implements GameLogicService {

    private Random random;

    public GameLogicServiceRandomImpl() {
        this.random = new Random();
    }

    @Override
    public boolean isHitTarget(Long shooterId, Long targetId) {
        return random.nextInt(10) > 4;
    }
}
