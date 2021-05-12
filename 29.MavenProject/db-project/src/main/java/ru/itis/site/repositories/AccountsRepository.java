package ru.itis.site.repositories;
import ru.itis.site.models.Account;

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
