package ru.itis.shcedule.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.UsersRepository;

import java.util.Optional;

@Service("accountUserDetailsService")
public class AccountUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        Optional<User> userOptional = usersRepository.findByTokens_Value(token);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new AccountUserDetails(user);

        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
