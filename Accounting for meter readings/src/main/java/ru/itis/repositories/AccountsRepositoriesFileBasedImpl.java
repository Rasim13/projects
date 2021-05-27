package ru.itis.repositories;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Account;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountsRepositoriesFileBasedImpl implements AccountsRepositories {

    private String fileName;
    private HSSFWorkbook hssfWorkbook;
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id;";

    public AccountsRepositoriesFileBasedImpl(String fileName, HSSFWorkbook hssfWorkbook, DataSource dataSource) {
        this.fileName = fileName;
        this.hssfWorkbook = hssfWorkbook;
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
                .dateOfSend(LocalDateTime.parse(row.getTime("date_of_send").toString()))
                .build();
    };

    public void saveToFile() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        // создаем лист
        HSSFSheet sheet = workbook.createSheet("Данные о пользователях");
        List<Account> accountList = findAll();

        int rowNum = 0;

        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Дата отправки");
        row.createCell(2).setCellValue("Имя");
        row.createCell(3).setCellValue("Фамилия");
        row.createCell(4).setCellValue("Номер квартиры");
        row.createCell(5).setCellValue("Показания горячей воды");
        row.createCell(6).setCellValue("Показания холодной воды");
        row.createCell(7).setCellValue("Показания электроэнергии");

        for (Account accountData:accountList) {
            createSheetHeader(sheet, ++ rowNum, accountData);
        }

        // записываем созданный в памяти Excel документ в файл
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(fileName));
            try {
                workbook.write(out);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }

    }

    public void createSheetHeader(HSSFSheet sheet, int rowNum, Account accountData) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(accountData.getId());
        row.createCell(1).setCellValue(accountData.getDateOfSend());
        row.createCell(2).setCellValue(accountData.getFirstName());
        row.createCell(3).setCellValue(accountData.getLastName());
        row.createCell(3).setCellValue(accountData.getNumberOfFlat());
        row.createCell(3).setCellValue(accountData.getAccountingOfHotWater());
        row.createCell(3).setCellValue(accountData.getAccountingOfColdWater());
        row.createCell(3).setCellValue(accountData.getAccountingOfPower());

    }


    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }

    @Override
    public Optional<Account> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findByFlat(Integer numberOfFlat) {
        return Optional.empty();
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
