package ru.itis.site.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.site.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Long> {
   Optional<Account> findByEmail(String email);
//   boolean existsAccountByConfirmId(String confirmId);
    Optional<Account> findByConfirmId(String confirmId);

}
