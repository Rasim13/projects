package ru.itis.site.sevices;

import ru.itis.site.dto.SearchAccountDto;

import java.util.List;

public interface AccountsService {
    List<SearchAccountDto> search(String query);
}
