package ru.itits.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itits.site.models.Account;
import ru.itits.site.repositories.AccountsRepository;

import java.util.Optional;

@Service
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Transactional
    @Override
    public boolean confirm(String confirmId) {
        Optional<Account> accountOptional = accountsRepository.findByConfirmId(confirmId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setState(Account.State.CONFIRMED);
            accountsRepository.save(account);
            return true;
        } else {
            return false;
        }
    }
}
