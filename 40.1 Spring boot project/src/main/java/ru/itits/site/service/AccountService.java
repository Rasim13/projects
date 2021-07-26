package ru.itits.site.service;

import ru.itits.site.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();
}
