package ru.itis.solution;

import ru.itis.solution.framework.Document;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Act implements Document {
    private LocalDate date;
    private String name;
    private String description;

    public Act(LocalDate data, String name, String description) {
        this.date = data;
        this.name = name;
        this.description = description;
    }


    @Override
    public String getTitle() {
        return "Акт";
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Act.class.getSimpleName() + "[", "]")
                .add(getTitle())
                .add("date=" + date)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
