package ru.itis.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.repositories.AccountsRepositories;
import ru.itis.repositories.AccountsRepositoriesToFileImpl;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AccountsRepositories saveDataToFile = context.getBean(AccountsRepositoriesToFileImpl.class);

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

        saveDataToFile.saveToFile();
    }
}
