package ru.itis.repositories;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Account;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AccountsRepositoriesToFileImpl implements AccountsRepositories {

    private JdbcTemplate jdbcTemplate;
    private String fileName;


    public AccountsRepositoriesToFileImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    private RowMapper<Account> accountRowMapper = (row, rowNumber) -> {
        return Account.builder()
                .id(row.getInt("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .numberOfFlat(row.getInt("number_of_flat"))
                .accountingOfHotWater(row.getInt("accounting_of_hot_water"))
                .accountingOfColdWater(row.getInt("accounting_of_hot_water"))
                .accountingOfPower(row.getInt("accounting_of_power"))
                .dateOfSend(LocalDateTime.parse(row.getString("date_of_send")))
                .build();
    };

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

    @Override
    public void saveToFile() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        // создаем лист
        HSSFSheet sheet = workbook.createSheet("Данные о пользователях");
        // заполняем список данными из базы данных
        List<Account> accountList = findAll();

        // создаем счетчик строки
        int rowNum = 0;

        // создаем подписи к столбцам
        extracted(sheet, rowNum);

        // заполняем лист данными
        for (Account accountData:accountList) {
            createSheetHeader(sheet, ++ rowNum, accountData);
        }

        FileOutputStream out = null;
        try {
            //записываем данные в файл
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

    private void extracted(HSSFSheet sheet, int rowNum) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Дата отправки");
        row.createCell(2).setCellValue("Имя");
        row.createCell(3).setCellValue("Фамилия");
        row.createCell(4).setCellValue("Номер квартиры");
        row.createCell(5).setCellValue("Показания горячей воды");
        row.createCell(6).setCellValue("Показания холодной воды");
        row.createCell(7).setCellValue("Показания электроэнергии");
    }

    public void createSheetHeader(HSSFSheet sheet, int rowNum, Account accountData) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(accountData.getId());
        row.createCell(1).setCellValue(accountData.getDateOfSend().toLocalDate().toString());
        row.createCell(2).setCellValue(accountData.getFirstName());
        row.createCell(3).setCellValue(accountData.getLastName());
        row.createCell(4).setCellValue(accountData.getNumberOfFlat());
        row.createCell(5).setCellValue(accountData.getAccountingOfHotWater());
        row.createCell(6).setCellValue(accountData.getAccountingOfColdWater());
        row.createCell(7).setCellValue(accountData.getAccountingOfPower());
    }


}
