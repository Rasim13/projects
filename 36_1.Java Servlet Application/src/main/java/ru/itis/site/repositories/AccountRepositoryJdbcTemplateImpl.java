package ru.itis.site.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.site.models.Account;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepositoryJdbcTemplateImpl implements AccountRepository {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    //language=SQL
    private static final String SQL_SEARCH = "select * from account where first_name ilike(:query) or last_name ilike (:query)";

    public AccountRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    // строка из БД мапиться (сопоставляется) в модель Account
    private RowMapper<Account> accountRowMapper = (row, rowNUmber) ->
            Account.builder()
                    .id(row.getLong("id"))
                    .firstName(row.getString("first_name"))
                    .lastName(row.getString("last_name"))
                    .experience(row.getInt("experience"))
                    .email(row.getString("email"))
                    .build();


    @Override
    public List<Account> findByFirstNameOrLastNameContains(String name) {
        Map<String, Object> params = Collections.singletonMap("query","%" + name +  "%");
        return namedJdbcTemplate.query(SQL_SEARCH, params, accountRowMapper);
    }
}
