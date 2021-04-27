package ru.itis.repositories;

import ru.itis.models.Account;

import java.util.List;

public interface AccountsRepository {
    List<Account> findAll();
    Account findById(Long id);

    void save(Account account);

    void update(Account account);

    void delete(Account account);

    void deleteById(Long id);

    void sortById();
}
