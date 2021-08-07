package ru.itis.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.forms.SignUpForm;
import ru.itis.site.models.Account;
import ru.itis.site.repositories.AccountsRepository;

import java.util.List;

import static ru.itis.site.dto.AccountDto.from;

@Service
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return from(accountsRepository.findAll());
    }

    @Override
    public void ban(Long userId) {
        Account account = accountsRepository.getById(userId);
        account.setState(Account.State.BANNED);
        accountsRepository.save(account);

    }

    @Override
    public List<AccountDto> getUsers(int page, int size) {
        //создаем объект Pagerequest
        PageRequest request = PageRequest.of(page, size);
        //получаем данные для страницы
        Page<Account> accountPage = accountsRepository.findAll(request);
        //у accountPage получим контент
        return from(accountPage.getContent());
    }

}
