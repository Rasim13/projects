package ru.itis.shcedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shcedule.models.Event;

public interface EventsRepository extends JpaRepository<Event, Long> {
}
