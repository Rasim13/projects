package ru.itis.site.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToMany
    @JoinTable(name = "driver_car",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id")
    )
    private List<Account> drivers;



}
