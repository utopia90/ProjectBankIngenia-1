package com.ingenia.projectbank.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
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

    @ApiModelProperty("Clave fecha tipo Date")
    private Date date;

    @ApiModelProperty("Clave cantidad tipo Double")
    private Double quantity;

    @ManyToOne()
    @ApiModelProperty("Clave cuenta tipo Account")
    @JoinColumn(name = "id_account")
    private Account account;

    @ManyToOne()
    @ApiModelProperty("Clave categoria tipo Category")
    @JoinColumn(name = "id_category")
    private Category category;

    public Movement() {
    }

    public Movement(OperationType operationType, PaymentType paymentType, Date date, Double quantity, Account account, Category category) {
        this.operationType = operationType;
        this.paymentType = paymentType;
        this.date = date;
        this.quantity = quantity;
        this.account = account;
        this.category = category;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", operationType=" + operationType +
                ", paymentType=" + paymentType +
                ", date=" + date +
                ", quantity=" + quantity +
                ", account=" + account +
                ", category=" + category +
                '}';
    }
}
