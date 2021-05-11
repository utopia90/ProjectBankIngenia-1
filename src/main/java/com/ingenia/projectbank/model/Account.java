package com.ingenia.projectbank.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @ApiModelProperty("Clave primaria tipo Long")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("Clave iban tipo String")
    private String iban;

    @ApiModelProperty("Clave saldo actual tipo Double")
    private Double currentBalance;

    @ApiModelProperty("Clave usuario tipo User")
    @ManyToMany(mappedBy="users", cascade = {CascadeType.PERSIST})
    private List<User> users = new ArrayList<>();

    @ApiModelProperty("Clave movimiento tipo Movement")
    @OneToMany(mappedBy = "account",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Movement> movements = new ArrayList<>();

    @ApiModelProperty("Clave Tarjeta tipo Card")
    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<BankCard> cards = new ArrayList<>();

    public Account() {
    }

    public Account(String iban, Double currentBalance, List<User> users, List<Movement> movements, List<BankCard> cards) {
        this.iban = iban;
        this.currentBalance = currentBalance;
        this.users = users;
        this.movements = movements;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public List<BankCard> getCards() {
        return cards;
    }

    public void setCards(List<BankCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", currentBalance=" + currentBalance +
                ", users=" + users +
                ", movements=" + movements +
                ", cards=" + cards +
                '}';
    }
}
