package ru.itis.site.services;

import ru.itis.site.dto.SearchAccountDto;


import java.util.List;


public interface AccountService {
    List<SearchAccountDto> search(String query);

}
