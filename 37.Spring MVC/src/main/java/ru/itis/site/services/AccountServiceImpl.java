package ru.itis.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.repositories.AccountsRepository;

import java.util.List;

import static ru.itis.site.dto.SearchAccountDto.from;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountsRepository accountsRepository;

    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return AccountDto.from(accountsRepository.findAll());
    }

    @Override
    public List<SearchAccountDto> search(String query) {
        return from(accountsRepository.findByFirstNameOrLastNameContains(query));
    }
}
