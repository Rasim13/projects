package ru.itis.app;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.download.SaveDataToFile;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SaveDataToFile saveDataToFile = context.getBean(SaveDataToFile.class);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();


//        Account account = Account.builder()
//                .firstName("Виктория")
//                .lastName("Казакова")
//                .numberOfFlat(75)
//                .accountingOfColdWater(5624)
//                .accountingOfHotWater(4857)
//                .accountingOfPower(4878)
//                .dateOfSend(LocalDateTime.now())
//                .build();
//        accountsRepositories.save(account);

        saveDataToFile.saveDataToExcel();


    }
}
