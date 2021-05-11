package com.ingenia.projectbank.model;

import javax.persistence.*;

@Entity
@Table(name = "tarjeta")
public class Tarjeta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
