package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Event;

public interface EventsRepository extends JpaRepository<Event, Long> {
}
