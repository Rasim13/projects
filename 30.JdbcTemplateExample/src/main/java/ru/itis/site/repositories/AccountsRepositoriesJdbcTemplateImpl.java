package ru.itis.site.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.site.models.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class AccountsRepositoriesJdbcTemplateImpl implements AccountsRepositories {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into" +
            " account(first_name, last_name, is_active) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update account set first_name = ?," +
            "last_name = ?, is_active = ? where id = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "delete from account where id = ?";

    //language=SQL
    private static final String SQL_DELETE_ACCOUNT = "delete from account where first_name = ?";

    private final JdbcTemplate jdbcTemplate;

    public AccountsRepositoriesJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Account> accountRowMapper = (row, rowNumber) -> {
        return Account.builder()
                .id(row.getLong("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .isActive(row.getBoolean("is_active"))
                .build();
    };


    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }

    @Override
    public Optional<Account> findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, accountRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Account account) {
        // keyHolder позволит получить доступ к сгенерированным базой данных ключам
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[] {"id"});
                statement.setString(1, account.getFirstName());
                statement.setString(2, account.getLastName());
                statement.setBoolean(3, account.getIsActive());
                return statement;
            }
        }, keyHolder);
        account.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update(SQL_UPDATE, account.getFirstName(), account.getLastName(), account.getIsActive(), account.getId());
    }

    @Override
    public void delete(Account account) {
        int status = jdbcTemplate.update(SQL_DELETE_ACCOUNT,account.getFirstName());
        if (status != 0) {
            System.out.println("Record have deleted");
        } else {
            System.out.println("Record doesn't exist");
        }
    }

    @Override
    public void deleteById(Long id) {
        int status = jdbcTemplate.update(SQL_DELETE_BY_ID, id);
        if (status != 0) {
            System.out.println("Record have deleted for ID " + id);
        } else {
            System.out.println("Record doesn't exist with ID " + id);
        }
    }
}
