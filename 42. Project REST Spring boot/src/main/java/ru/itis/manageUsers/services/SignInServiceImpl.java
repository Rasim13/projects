package ru.itis.manageUsers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.manageUsers.dto.AuthDto;
import ru.itis.manageUsers.dto.TokenDto;
import ru.itis.manageUsers.models.Token;
import ru.itis.manageUsers.models.User;
import ru.itis.manageUsers.repositories.TokensRepository;
import ru.itis.manageUsers.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Реализация интерфейса авторизации пользователя
 */

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto signIn(AuthDto auth) {
        Optional<User> userOptional = usersRepository.findByEmail(auth.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(auth.getHashPassword(), user.getHashPassword())) {
                String value = UUID.randomUUID().toString();
                Token token = Token.builder()
                        .value(value)
                        .user(user)
                        .build();
                tokensRepository.save(token);
                return new TokenDto(value);
            } else {
                throw new IllegalArgumentException("Wrong email/password");
            }

        } else {
            throw new IllegalArgumentException("Wrong email/password");
        }
    }
}
