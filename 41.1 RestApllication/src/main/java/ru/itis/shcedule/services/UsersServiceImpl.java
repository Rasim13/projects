package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.forms.UserForm;
import ru.itis.shcedule.models.Event;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.shcedule.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

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

}
