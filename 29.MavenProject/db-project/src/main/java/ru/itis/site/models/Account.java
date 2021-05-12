package ru.itis.site.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isActive;

}
