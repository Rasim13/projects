package ru.itis.site.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.itis.site.models.Account;
import ru.itis.site.repositories.AccountsRepositories;
import ru.itis.site.repositories.AccountsRepositoriesJdbcTemplateImpl;

import javax.sql.DataSource;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/javaitis13");
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername("postgres");
        config.setPassword("sql2021");
        config.setMaximumPoolSize(50);

        DataSource dataSource = new HikariDataSource(config);

        AccountsRepositories accountsRepositories = new AccountsRepositoriesJdbcTemplateImpl(dataSource);

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

    }
}
