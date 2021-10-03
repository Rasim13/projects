package ru.itis.shcedule.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.AuthDto;
import ru.itis.shcedule.dto.JWTTokenDto;
import ru.itis.shcedule.models.JWTToken;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.JWTSRepository;
import ru.itis.shcedule.repositories.TokensRepository;
import ru.itis.shcedule.repositories.UsersRepository;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    @Value("${jwt.token.secret}")
    private String secret;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private JWTSRepository jwtsRepository;

    @Override
    public JWTTokenDto signIn(AuthDto auth) {
        Optional<User> userOptional = usersRepository.findByEmail(auth.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(auth.getHashPassword(), user.getHashPassword())) {
                String value = JWT.create()
                        .withSubject(user.getId().toString())
                        .withClaim("email", user.getEmail())
//                        .withClaim("role", user.getRole().toString())
//                        .withClaim("state", user.getState().toString())
                        .sign(Algorithm.HMAC256(secret));
//                JWTToken jwtValue = JWTToken.builder()
//                        .jwtValue(value)
//                        .user(user)
//                        .build();
//                jwtsRepository.save(jwtValue);
                return new JWTTokenDto(value);
            } else {
                throw new IllegalArgumentException("Wrong email/password");
            }
        } else {
            throw new IllegalArgumentException("Wrong email/password");
        }
    }

//    @Override
//    public TokenDto signIn(AuthDto auth) {
//        Optional<User> userOptional = usersRepository.findByEmail(auth.getEmail());
//
//        if (userOptional.isPresent()) {
//
//            User user = userOptional.get();
//
//            if (passwordEncoder.matches(auth.getHashPassword(),user.getHashPassword())) {
//                String value = UUID.randomUUID().toString();
//                Token token = Token.builder()
//                        .value(value)
//                        .user(user)
//                        .build();
//                tokensRepository.save(token);
//                return new TokenDto(value);
//            } else {
//                throw new IllegalArgumentException("Wrong email/password");
//            }
//
//        } else {
//            throw new IllegalArgumentException("Wrong email/password");
//        }
//    }
}
