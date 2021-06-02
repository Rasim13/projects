package ru.itis.site.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.repostories.AccountsRepository;

import java.util.List;

import static ru.itis.site.dto.SearchAccountDto.from;

@Service
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }


    @Override
    public List<SearchAccountDto> search(String query) {
        return from(accountsRepository.findByFirstNameOrLastNameContains(query));
    }
}
