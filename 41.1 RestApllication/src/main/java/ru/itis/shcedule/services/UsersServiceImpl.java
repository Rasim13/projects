package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.dto.TimeDto;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.forms.UserForm;
import ru.itis.shcedule.models.Event;
import ru.itis.shcedule.models.Time;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.EventsRepository;
import ru.itis.shcedule.repositories.UsersRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.shcedule.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public List<EventDto> getEventsByUser(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        List<Event> events = user.getEvents();
        return events.stream().map(EventDto::from).collect(Collectors.toList());
    }

    @Override
    public UserDto addUser(UserForm userForm) {
        User newUser = User.builder()
                .email(userForm.getEmail())
                .name(userForm.getName())
                .hashPassword(passwordEncoder.encode(userForm.getHashPassword()))
                .build();
        usersRepository.save(newUser);
        return from(newUser);
    }

    @Override
    public TimeDto getGeneralTime(Time time) {
        User user = null;
        List<Event> findEventUser = null;
        List<User> users = time.getUsers();

        for (User findUser : users) {
            user = usersRepository.findById(findUser.getId()).orElseThrow(IllegalArgumentException::new);
            if (user == null) {
                throw new IllegalArgumentException();
            }
        }

        TimeDto timeDto = findGeneralTime(time, user);

        return timeDto;
    }

    private TimeDto findGeneralTime(Time time, User user) {

        List<Event> eventList = usersRepository.findByUser(user);

        LocalDate dateFromJson = time.getDate();

        for (Event event1: eventList)
            if (!dateFromJson.isEqual(event1.getDate())) {
                throw new IllegalArgumentException("Not same date");
            } else {
                for (Event firstUser: eventList) {

                    for (Event secondUser: eventList) {

                        if (firstUser.getStartTime().equals(secondUser.getStartTime())
                                && firstUser.getFinishTime().equals(secondUser.getFinishTime())) {
                            throw new IllegalArgumentException("There is same time");
                        } else {
                            return TimeDto.builder()
                                    .freeTime(firstUser.getFinishTime())
                                    .build();
                        }
                    }

                }
            }

        return null;
        }
    }

