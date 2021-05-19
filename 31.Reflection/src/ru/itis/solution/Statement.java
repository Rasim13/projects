package ru.itis.solution;

import ru.itis.solution.framework.Document;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Statement implements Document {
    private String name;
    private LocalDate birthDate;

    @Default(value = "ITIS")
    private String company;

    @Default(value = "BOSS")
    private String reviewer;


    public Statement(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }


    @Override
    public String getTitle() {
        return "Заявление";
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Statement.class.getSimpleName() + "[", "]")
                .add(getTitle())
                .add("name='" + name + "'")
                .add("birthDate=" + birthDate)
                .toString();
    }
}
