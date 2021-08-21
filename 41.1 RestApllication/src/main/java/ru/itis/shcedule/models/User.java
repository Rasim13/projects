package ru.itis.shcedule.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @OneToMany (mappedBy = "user")
    private List<Event> events;

    public void addEventToUser(Event event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
        event.setUser(this);
    }

}
