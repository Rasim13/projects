package ru.itis.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Account;
import ru.itis.repositories.AccountsRepositories;
import ru.itis.repositories.AccountsRepositoriesJdbcTemplateImpl;
import ru.itis.repositories.AccountsRepositoriesToFileImpl;
import ru.itis.services.Calculation;
import ru.itis.services.CalculationImpl;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Calculation accountsRepositories = context.getBean(CalculationImpl.class);

//        Account account = Account.builder()
//                .firstName("Расим")
//                .lastName("Замалтдинов")
//                .numberOfFlat(13)
//                .accountingOfColdWater(132)
//                .accountingOfHotWater(128)
//                .accountingOfPower(500)
//                .dateOfSend(LocalDate.now())
//                .build();
//        accountsRepositories.save(account);
//        accountRepositories.saveToFile();
        accountsRepositories.calculationConsumption(13);
    }
}
