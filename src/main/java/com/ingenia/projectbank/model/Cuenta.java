package com.ingenia.projectbank.model;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
