package ru.itis.manageUsers.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERS = {"FirstName", "LastName"};
    static String SHEET = "users";

    public static boolean hasExcelFormat(MultipartFile file) {

        //проверяем тип файла
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<User> excelToUsers(InputStream file) {
        try {
            //получаем объект XSSWorkBook для обработки xlsx файла
            Workbook workbook = new XSSFWorkbook(file);
            // разбираем лист входного файла на объектную модель
            Sheet sheet = workbook.getSheet(SHEET);
            // Получаем Iterator по всем строкам в листе
            Iterator<Row> rows = sheet.iterator();
            // создаем List для хранения нашей модели
            List<User> users = new ArrayList<User>();
            //создаем счетчик строки
            int rowNumber = 0;
            // проходим по всему листу
            while (rows.hasNext()) {
                //итерируемся по строке
                Row currentRow = rows.next();
                //пропускаем заголовки
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                //итерируемся по ячейкам в строке
                Iterator<Cell> cellsInRow = currentRow.iterator();
                // создаем объект
                User user = new User();
                //создаем счетчик ячейки
                int cellIdx = 0;
                //проходим по всем ячейкам
                while (cellsInRow.hasNext()) {
                    //Получаем текущую ячейку
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            user.setFirstName(currentCell.getStringCellValue());
                            break;

                        case 1:
                            user.setLastName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            String dateInString = currentCell.getStringCellValue();

                            try {
                                Date date = formatter.parse(dateInString);
                                user.setBirthday(date);
                            } catch (ParseException e) {
                                throw new IllegalArgumentException();
                            }

                            break;

                        case 3:
                            user.setAddress(currentCell.getStringCellValue());
                            break;

                        case 4:
                            user.setAboutMyself(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                users.add(user);
            }

            workbook.close();

            return users;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}