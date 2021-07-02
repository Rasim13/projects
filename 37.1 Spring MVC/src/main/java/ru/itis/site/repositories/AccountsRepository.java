package ru.itis.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import ru.itis.site.models.Account;

public interface AccountsRepository extends JpaRepository<Account, Long> {

}
