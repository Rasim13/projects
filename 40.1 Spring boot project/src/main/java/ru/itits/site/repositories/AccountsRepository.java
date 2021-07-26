package ru.itits.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itits.site.models.Account;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByConfirmId(String confirmId);
}
