package ru.itis.site.services;

import ru.itis.site.dto.AccountDto;

import java.util.List;


public interface AccountsService {
    List<AccountDto> getAll();
}
