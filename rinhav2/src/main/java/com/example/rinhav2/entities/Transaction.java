package com.example.rinhav2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
//@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "transaction_id")
    private Integer transactionId;
    @NotBlank
    private Integer value;
    @NotBlank
    private Character type;
    @NotBlank
    private String description;
    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;
    private final LocalDateTime timeStamp;

    public Transaction(Integer value, Character type, String description, Customer customer) {
        this.value = value;
        this.type = type;
        this.description = description;
        this.customer = customer;
        this.timeStamp = LocalDateTime.now();
    }

    public Integer getValue() {
        return value;
    }

    public Character getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(value, that.value) && Objects.equals(timeStamp, that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, timeStamp);
    }
}
