package ru.itis.site.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.itis.site.repositories.AccountsRepository;
import ru.itis.site.repositories.AccountsRepositoryJdbcImpl;
import ru.itis.site.utils.db.CustomDataSource;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) throws Exception {
//        DataSource dataSource = new CustomDataSource("postgres", "sql2021", "jdbc:postgresql://localhost:5432/javaitis13");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/javaitis13");
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername("postgres");
        config.setPassword("sql2021");
        config.setMaximumPoolSize(50);

        DataSource dataSource = new HikariDataSource(config);

        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);
        System.out.println(accountsRepository.findAll());

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                accountsRepository.findAll();
            }
        });

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                accountsRepository.findAll();
            }
        });

    }
}
