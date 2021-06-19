package ru.itis.site.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.site.models.Account;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountsRepositoryJdbcTemplateImpl implements AccountsRepository {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    //language=SQL
    private static final String SQL_SEARCH = "select * from account where first_name ilike(:query) or last_name ilike (:query)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into account(first_name, last_name, email, hash_password) " +
            "values (:firstName, :lastName, :email, :hashPassword)";

    public AccountsRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
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

    @Override
    public List<Account> findAll() {
        return namedJdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }

    @Override
    public void save(Account entity) {
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", entity.getFirstName());
        params.put("lastName", entity.getLastName());
        params.put("email", entity.getEmail());
        params.put("hashPassword", entity.getHashPassword());

        SqlParameterSource source = new MapSqlParameterSource(params);

        namedJdbcTemplate.update(SQL_INSERT_USER, source, holder, new String[]{"id"});
        entity.setId(holder.getKey().longValue());
    }
}
