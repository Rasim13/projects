package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.dto.AuthDto;
import ru.itis.dto.JwtTokenDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.provider.JwtProvider;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public JwtTokenDto signIn(AuthDto auth) {
        Optional<User> userOptional = usersRepository.findByEmail(auth.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(auth.getHashPassword(), user.getHashPassword())) {
                String jwtToken = jwtProvider.generateToken(auth.getEmail());
                return new JwtTokenDto(jwtToken);
            } else {
                throw new IllegalArgumentException("Wrong email/password");
            }
        } else {
            throw new IllegalArgumentException("Wrong email/password");
        }
    }

}
