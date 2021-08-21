package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.forms.UserForm;
import ru.itis.shcedule.models.Event;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.EventsRepositories;
import ru.itis.shcedule.repositories.UsersRepositories;

import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.shcedule.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepositories usersRepositories;

    @Autowired
    private EventsRepositories eventsRepositories;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepositories.findAll());
    }

    @Override
    public List<EventDto> getEventsByUser(Long userId) {
        User user = usersRepositories.findById(userId).orElseThrow(IllegalArgumentException::new);

        if (user == null) {
            throw new IllegalArgumentException("User doesn't exist with " + userId);
        }

        List<Event> event = eventsRepositories.findAll();

        return event.stream().map(EventDto::from).collect(Collectors.toList());
    }

    @Override
    public UserDto addUser(UserForm userForm) {
       User newUser = User.builder()
               .email(userForm.getEmail())
               .name(userForm.getName())
               .build();
        usersRepositories.save(newUser);
        return from(newUser);
    }
}
