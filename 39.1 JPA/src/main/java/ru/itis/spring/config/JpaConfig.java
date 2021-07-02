package ru.itis.spring.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement // аннотация для управления транцакзиями
@ComponentScan("ru.itis.spring")
public class JpaConfig {



    // компонент spring'a который создает EntityManager (данный бин установит связь между spring и hibernate, EntityManager это интерфейс jpa
    // который позволяет работать с базой данных)
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // сделать адаптер для hibernate
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        // пишем, что используем базу данных Postgres
        adapter.setDatabase(Database.POSTGRESQL);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        // в entityManagerFactory кладем адаптер
        entityManagerFactory.setJpaVendorAdapter(adapter);
        // кладем datasource
        entityManagerFactory.setDataSource(dataSource());
        // кладем properties
        entityManagerFactory.setJpaProperties(properties());
        entityManagerFactory.setPackagesToScan("ru.itis.spring.models", "ru.itis.spring.repositories");
        return entityManagerFactory;
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/hibernate_db");
        config.setDriverClassName("org.postgresql.Driver");
        config.setPassword("sql2021");
        config.setUsername("postgres");
        config.setMaximumPoolSize(20);
        return config;
    }

    @Bean
    // данный бин отвечает за автоматическое открытие и закрытие транзакции
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","create");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        return properties;
    }
}
