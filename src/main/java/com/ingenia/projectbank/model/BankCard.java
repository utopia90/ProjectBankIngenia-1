package com.ingenia.projectbank.model;

import javax.persistence.*;

@Entity
@Table(name = "bankcard")
public class BankCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
