package ru.itis.site.repostories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.site.models.Account;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Repository
public class AccountsRepositoryJdbcTemplateImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_SEARCH = "select * from account where first_name ilike (:query) or last_name ilike (:query)";
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public AccountsRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    private RowMapper<Account> accountRowMapper = (row, rowNumber) ->
            Account.builder()
                    .id(row.getLong("id"))
                    .firstName(row.getString("first_name"))
                    .lastName(row.getString("last_name"))
                    .experience(row.getInt("experience"))
                    .email(row.getString("email"))
                    .build();


    @Override
    public List<Account> findByFirstNameOrLastNameContains(String name) {
        Map<String, Object> params = Collections.singletonMap("query", "%" + name + "%");
        return namedJdbcTemplate.query(SQL_SEARCH, params, accountRowMapper);
    }
}
