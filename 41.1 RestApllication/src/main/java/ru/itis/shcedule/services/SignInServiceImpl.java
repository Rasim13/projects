package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.AuthDto;
import ru.itis.shcedule.dto.TokenDto;
import ru.itis.shcedule.models.Token;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.TokensRepository;
import ru.itis.shcedule.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokensRepository tokensRepository;


    @Override
    public TokenDto signIn(AuthDto auth) {
        Optional<User> userOptional = usersRepository.findByEmail(auth.getEmail());

        if (userOptional.isPresent()) {

            User user = userOptional.get();

            if (passwordEncoder.matches(auth.getHashPassword(),user.getHashPassword())) {
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
