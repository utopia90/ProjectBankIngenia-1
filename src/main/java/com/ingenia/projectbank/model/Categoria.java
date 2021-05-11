package com.ingenia.projectbank.model;

import javax.persistence.*;


@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
