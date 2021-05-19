package ru.itis.solution;

import ru.itis.solution.framework.DocumentsFramework;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        DocumentsFramework framework = new DocumentsFramework();
        Statement statement = framework.generateText(Statement.class,
                "Замалтдинов Расим",
                LocalDate.of(1992, 5, 24));
        Act act = framework.generateText(Act.class,
                LocalDate.of(2020,10, 1),
                "Сверка", "Провели сверку документов");

        System.out.println(statement);
        System.out.println(act);
    }
}
