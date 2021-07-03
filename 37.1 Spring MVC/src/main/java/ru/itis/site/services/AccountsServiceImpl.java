package ru.itis.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.forms.SignUpForm;
import ru.itis.site.repositories.AccountsRepository;

import java.util.List;

import static ru.itis.site.dto.SearchAccountDto.from;

@Profile("production")
@Service
public class AccountsServiceImpl implements AccountsService {


    private final AccountsRepository accountsRepository;
    private final SignUpService signUpService;

    @Autowired
    public AccountsServiceImpl(AccountsRepository accountsRepository, SignUpService signUpService) {
        this.accountsRepository = accountsRepository;
        this.signUpService = signUpService;
    }

    @Override
    public List<AccountDto> getAll() {
        return AccountDto.from(accountsRepository.findAll());
    }

    @Override
    public List<SearchAccountDto> search(String query) {
//        return from(accountsRepository.findByFirstNameOrLastNameContains(query));
        return null;
    }

    @Override
    public void addUser(SignUpForm form) {
        signUpService.signUp(form);

    }
}
