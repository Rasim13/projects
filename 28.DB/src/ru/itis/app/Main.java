package ru.itis.app;

import ru.itis.models.Account;
import ru.itis.repositories.AccountsRepository;
import ru.itis.repositories.AccountsRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaitis13","postgres","sql2021");
        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(connection);
//        System.out.println(accountsRepository.findAll());
//        System.out.println(accountsRepository.findById(8L));
//
//        Account account = new Account("Антон", "Петров", false);
//        accountsRepository.save(account);
//        System.out.println(account);
//
//        Account rasim = accountsRepository.findById(9L);
//        rasim.setLastName("Миннебаев");
//        accountsRepository.update(rasim);
        accountsRepository.delete(new Account("Антон", "Петров", false));
//        accountsRepository.sortById();


    }
}
