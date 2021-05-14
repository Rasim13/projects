package ru.itis.site.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isActive;

    public Account(String firstName, String lastName, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
    }

    public Account(String firstName) {
        this.firstName = firstName;
    }
}
