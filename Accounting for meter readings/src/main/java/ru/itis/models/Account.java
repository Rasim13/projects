package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer numberOfFlat;
    private Integer accountingOfHotWater;
    private Integer accountingOfColdWater;
    private Integer accountingOfPower;
    private LocalDateTime dateOfSend;

    public Account(String firstName, String lastName, Integer numberOfFlat){
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfFlat = numberOfFlat;
    }

}
