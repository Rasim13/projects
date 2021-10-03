package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {

    private Long id;
    private String nameOfTheEvent;

    private LocalTime startTime;
    private LocalTime finishTime;
    private LocalDate date;

    public static EventDto from(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .nameOfTheEvent(event.getNameOfTheEvent())
                .date(event.getDate())
                .startTime(event.getStartTime())
                .finishTime(event.getFinishTime())
                .build();
    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream().map(EventDto::from).collect(Collectors.toList());
    }
}
