package ru.itis.site.services;

import ru.itis.site.dto.AccountDto;
import ru.itis.site.dto.SearchAccountDto;


import java.util.List;


public interface AccountService {
    List<AccountDto> getAll();
    List<SearchAccountDto> search(String query);

}
