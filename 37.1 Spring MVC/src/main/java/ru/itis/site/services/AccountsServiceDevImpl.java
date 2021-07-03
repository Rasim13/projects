package ru.itis.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.forms.SignUpForm;
import ru.itis.site.repositories.AccountsRepository;

import java.util.Arrays;
import java.util.List;

@Profile("dev") // данная аннотация загружает файл dev (для тестирования приложения)
@Service
public class AccountsServiceDevImpl implements AccountsService {

    @Override
    public List<AccountDto> getAll() {
        return Arrays.asList(
                AccountDto.builder()
                .firstName("Fake first name 1")
                .lastName("Fake last name 1")
                .email("Fake email 1")
                .build(),
                AccountDto.builder()
                        .firstName("Fake first name 2")
                        .lastName("Fake last name 2")
                        .email("Fake email 2")
                        .build(),
                AccountDto.builder()
                        .firstName("Fake first name 3")
                        .lastName("Fake last name 3")
                        .email("Fake email 3")
                        .build()
        );
    }

    @Override
    public List<SearchAccountDto> search(String query) {
//        return from(accountsRepository.findByFirstNameOrLastNameContains(query));
        return null;
    }

    @Override
    public void addUser(SignUpForm form) {
    }
}
