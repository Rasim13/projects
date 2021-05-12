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

}
