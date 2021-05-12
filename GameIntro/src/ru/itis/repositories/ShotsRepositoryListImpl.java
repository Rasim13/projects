package ru.itis.repositories;

import ru.itis.models.Shot;

import java.util.ArrayList;
import java.util.List;

public class ShotsRepositoryListImpl implements ShotsRepository {

    private List<Shot> shots;

    public ShotsRepositoryListImpl() {
        this.shots = new ArrayList<>();
    }

    @Override
    public void save(Shot shot) {
        shots.add(shot);
    }
}
