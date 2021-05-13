package com.ingenia.projectbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movement")
public class Movement {

    @Id
    @Column(name = "id")
    @ApiModelProperty("Clave primaria tipo Long")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty("Clave tipo de operación tipo Enum")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @ApiModelProperty("Clave tipo de pago tipo Enum")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ApiModelProperty("Clave fecha tipo Localdate")
    private Instant date;

    @ApiModelProperty("Clave cantidad tipo Double")
    private Double quantity;

    @ManyToOne()
    @ApiModelProperty("Clave cuenta tipo Account")
    @JoinColumn(name = "id_account")
    @JsonIgnoreProperties("movements")
    private Account account;
    //TODO---------------------------------------
    //@Column(name = "remaining-balance")
    private double remainingBalance;
    private double reminingCreditBalance;


    //TODO---------------------------------------
    @ApiModelProperty("Clave tipo categoría tipo Enum")
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;


    public Movement() {
    }

    public Movement(OperationType operationType, PaymentType paymentType, Instant date, Double quantity, Account account, CategoryType categoryType) {
        this.operationType = operationType;
        this.paymentType = paymentType;
        this.date = date;
        this.quantity = quantity;
        this.account = account;
        this.categoryType = categoryType;
    }

    //TODO---------------------------------------
    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public double getReminingCreditBalance() {
        return reminingCreditBalance;
    }

    public void setReminingCreditBalance(double reminingCreditBalance) {
        this.reminingCreditBalance = reminingCreditBalance;
    }

    //TODO---------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

}