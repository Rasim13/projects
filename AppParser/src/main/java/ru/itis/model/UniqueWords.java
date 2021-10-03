package ru.itis.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="unique_words")
public class UniqueWords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "amount_of_word")
    private Integer amountOfWord;
}
