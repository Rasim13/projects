package ru.itis.site.repositories;

import ru.itis.site.models.Account;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByFirstNameOrLastNameContains(String name);
}
