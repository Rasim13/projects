package ru.itis.download;

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
import java.util.List;

public class SaveDataToFileExcelImpl implements SaveDataToFile {
    private JdbcTemplate jdbcTemplate;

    public SaveDataToFileExcelImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
                .build();
    };

    @Override
    public void saveDataToExcel() {
        // создаем самого excel файла
        HSSFWorkbook workbook = new HSSFWorkbook();
        // создаем лист
        HSSFSheet sheet = workbook.createSheet("Данные о пользователях");
        // заполняем список данными из базы данных
        List<Account> accountList = findAll();

        // создаем счетчик строки
        int rowNum = 0;

        // создаем подписи к столбцам
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Дата отправки");
        row.createCell(2).setCellValue("Имя");
        row.createCell(3).setCellValue("Фамилия");
        row.createCell(4).setCellValue("Номер квартиры");
        row.createCell(5).setCellValue("Показания горячей воды");
        row.createCell(6).setCellValue("Показания холодной воды");
        row.createCell(7).setCellValue("Показания электроэнергии");

        // заполняем лист данными
        for (Account accountData:accountList) {
            createSheetHeader(sheet, ++ rowNum, accountData);
        }

        FileOutputStream out = null;
        try {
            //записываем данные в файл
            out = new FileOutputStream(new File("Данные.xls"));
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
        row.createCell(4).setCellValue(accountData.getNumberOfFlat());
        row.createCell(5).setCellValue(accountData.getAccountingOfHotWater());
        row.createCell(6).setCellValue(accountData.getAccountingOfColdWater());
        row.createCell(7).setCellValue(accountData.getAccountingOfPower());
    }

    public List<Account> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }
}
