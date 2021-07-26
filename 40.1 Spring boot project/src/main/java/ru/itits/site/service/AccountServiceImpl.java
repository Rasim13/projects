package ru.itits.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itits.site.dto.AccountDto;
import ru.itits.site.repositories.AccountsRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return AccountDto.from(accountsRepository.findAll());
    }
}
