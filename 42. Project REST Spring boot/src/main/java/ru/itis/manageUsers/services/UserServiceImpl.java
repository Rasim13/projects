package ru.itis.manageUsers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.forms.UserForm;
import ru.itis.manageUsers.models.User;
import ru.itis.manageUsers.repositories.UsersRepository;

import java.util.List;

import static ru.itis.manageUsers.dto.UserDto.from;

/**
 * Реализация интерфейса управления пользователем
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto addUser(UserForm userForm) {
        User newUser = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .birthday(userForm.getBirthday())
                .address(userForm.getAddress())
                .aboutMyself(userForm.getAboutMyself())
                .email(userForm.getEmail())
                .hashPassword(passwordEncoder.encode(userForm.getHashPassword()))
                .build();
        usersRepository.save(newUser);
        return from(newUser);
    }

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public List<UserDto> deleteUserById(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        usersRepository.delete(user);
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto updateUser(Long userId, UserForm userFom) {
        User userForUpdate = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        update(userFom, userForUpdate);
        usersRepository.save(userForUpdate);
        return from(usersRepository.getById(userId));
    }

    @Override
    public UserDto findUserByName(String name) {
        User userByFirstName = usersRepository.findUserByFirstNameContaining(name).orElseThrow(IllegalArgumentException::new);
        return from(userByFirstName);
    }

    @Override
    public UserDto findUserByLastName(String lastName) {
        User userByLastName = usersRepository.findUserByLastNameContaining(lastName).orElseThrow(IllegalArgumentException::new);
        return from(userByLastName);
    }

    private void update (UserForm userFom, User userForUpdate) {
        if (userFom.getAddress() != null) {
            userForUpdate.setAddress(userFom.getAddress());
        } else {
            userForUpdate.setAddress(userForUpdate.getAddress());
        }

        if (userFom.getAboutMyself() != null) {
            userForUpdate.setAboutMyself(userFom.getAboutMyself());
        }  else {
            userForUpdate.setAboutMyself(userForUpdate.getAboutMyself());
        }

        if (userFom.getEmail() != null) {
            userForUpdate.setEmail(userFom.getEmail());
        } else {
            userForUpdate.setEmail(userForUpdate.getEmail());
        }

        if (userFom.getHashPassword() != null) {
            userForUpdate.setHashPassword(userFom.getHashPassword());
        } else {
            userForUpdate.setHashPassword(userForUpdate.getHashPassword());
        }
    }
}
