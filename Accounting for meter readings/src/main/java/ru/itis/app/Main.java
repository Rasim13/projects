package ru.itis.app;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Account;
import ru.itis.repositories.AccountsRepositories;
import ru.itis.repositories.AccountsRepositoriesFileBasedImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AccountsRepositories accountsRepositories = context.getBean(AccountsRepositories.class);
        AccountsRepositoriesFileBasedImpl accountsRepositories1 = new AccountsRepositoriesFileBasedImpl("D:\\Данные.xlsx", new HSSFWorkbook());
        accountsRepositories1.saveToFile();

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
        accountsRepositories.delete(new Account("Виктория", "Казакова", 75));

    }
}
