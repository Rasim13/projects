package ru.itis.services;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Account;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CalculationImpl implements Calculation {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_BY_FLAT = "select * from account where number_of_flat = ?";

    public CalculationImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Account> accountRowMapper = (row, rowNumber) -> {
        return Account.builder()
                .numberOfFlat(row.getInt("number_of_flat"))
                .accountingOfHotWater(row.getInt("accounting_of_hot_water"))
                .accountingOfColdWater(row.getInt("accounting_of_hot_water"))
                .accountingOfPower(row.getInt("accounting_of_power"))
                .dateOfSend(LocalDate.parse(row.getTime("date_of_send").toString()))
                .build();
    };

    public List<Account> findByFlat(Integer numberOfFlat) {
            return (List<Account>) jdbcTemplate.queryForObject(SQL_SELECT_BY_FLAT, accountRowMapper, numberOfFlat);
    }

    @Override
    public void calculationConsumption(int numberOfFlat) {
        List<Account> accounts = findByFlat(numberOfFlat);
        for (Account record: accounts) {
            System.out.println(record.getDateOfSend());
            System.out.println(record.getNumberOfFlat());
            System.out.println(record.getAccountingOfHotWater());
            System.out.println(record.getAccountingOfColdWater());
            System.out.println(record.getAccountingOfHotWater());
        }

    }
}
