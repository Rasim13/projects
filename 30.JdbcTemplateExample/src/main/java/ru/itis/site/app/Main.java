package ru.itis.site.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.site.models.Account;
import ru.itis.site.repositories.AccountsRepositories;
import ru.itis.site.repositories.AccountsRepositoriesJdbcTemplateImpl;

import javax.sql.DataSource;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AccountsRepositories accountsRepositories = context.getBean(AccountsRepositories.class);

        Account account = Account.builder()
                .firstName("TEMP")
                .lastName("TEMP2")
                .isActive(true)
                .build();
        accountsRepositories.save(account);
        System.out.println(account);

//        accountsRepositories.save(Account.builder()
//                .firstName("TEMP")
//                .lastName("TEMP2")
//                .isActive(true)
//                .build()
//        );

//        Account account = accountsRepositories.findById(13L);
//        account.setFirstName("ГЛАВНЫЙ");
//        accountsRepositories.update(account);

//        System.out.println(accountsRepositories.findAll());

//        Optional<Account> accountOptional = accountsRepositories.findById(100L);
//
//        if (accountOptional.isPresent()) {
//            Account account = accountOptional.get();
//            System.out.println(account);
//        } else {
//            System.out.println("Объект не найден");
//        }

//        accountsRepositories.deleteById(14L);
        accountsRepositories.delete(new Account("ГЛАВНЫЙ"));

    }
}
