package ru.itis.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.repositories.AccountRepository;

import java.util.List;

import static ru.itis.site.dto.SearchAccountDto.from;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return AccountDto.from(accountRepository.findAll());
    }

    @Override
    public List<SearchAccountDto> search(String query) {
        return from(accountRepository.findByFirstNameOrLastNameContains(query));
    }
}
