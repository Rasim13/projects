package ru.itis.repositories;

import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.models.Account;
import ru.itis.services.CalculationImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AccountsRepositoriesJdbcTemplateImpl implements AccountsRepositories {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_FLAT = "select * from account where number_of_flat = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into" +
            " account(first_name, last_name, number_of_flat, accounting_of_hot_water," +
            "accounting_of_cold_water, accounting_of_power, date_of_send) values (?, ?, ?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update account set first_name = ?," +
            "last_name = ? where number_of_flat = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "delete from account where id = ?";

    //language=SQL
    private static final String SQL_DELETE_ACCOUNT = "delete from account where number_of_flat = ?";

    public final JdbcTemplate jdbcTemplate;

    public AccountsRepositoriesJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Account> accountRowMapper = (row, rowNumber) -> {
        return Account.builder()
                .id(row.getInt("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .numberOfFlat(row.getInt("number_of_flat"))
                .accountingOfHotWater(row.getInt("accounting_of_hot_water"))
                .accountingOfColdWater(row.getInt("accounting_of_hot_water"))
                .accountingOfPower(row.getInt("accounting_of_power"))
                .dateOfSend(LocalDate.parse(row.getTime("date_sof_send").toString()))
                .build();
    };

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, accountRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Account> findByFlat(Integer numberOfFlat) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_FLAT, accountRowMapper, numberOfFlat));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Account account) {
        // keyHolder ???????????????? ???????????????? ???????????? ?? ?????????????????????????????? ?????????? ???????????? ????????????
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[] {"id"});
                statement.setString(1, account.getFirstName());
                statement.setString(2, account.getLastName());
                statement.setInt(3, account.getNumberOfFlat());
                statement.setInt(4, account.getAccountingOfHotWater());
                statement.setInt(5, account.getAccountingOfColdWater());
                statement.setInt(6, account.getAccountingOfPower());
                statement.setString(7, account.getDateOfSend().toString());
                return statement;
            }
        }, keyHolder);
        account.setId(keyHolder.getKey().intValue());

    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update(SQL_UPDATE, account.getFirstName(), account.getLastName(), account.getNumberOfFlat());
    }

    @Override
    public void delete(Account account) {
        int status = jdbcTemplate.update(SQL_DELETE_ACCOUNT,account.getNumberOfFlat());
        if (status != 0) {
            System.out.println("Record have deleted");
        } else {
            System.out.println("Record doesn't exist");
        }
    }

    @Override
    public void deleteById(Integer id) {
        int status = jdbcTemplate.update(SQL_DELETE_BY_ID, id);
        if (status != 0) {
            System.out.println("Record have deleted for ID " + id);
        } else {
            System.out.println("Record doesn't exist with ID " + id);
        }
    }

    @Override
    public void saveToFile() {
        throw new NotImplementedException("?????? ????????????????????");
    }
}
