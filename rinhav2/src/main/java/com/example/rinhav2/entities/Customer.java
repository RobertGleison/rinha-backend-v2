package com.example.rinhav2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    //@TODO: Maybe the best type option should be BigDecimal.
    @NotBlank
    private Integer creditLimit;
    @NotBlank
    private Integer balance;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public Customer(Integer creditLimit, Integer balance) {
        this.creditLimit = creditLimit;
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getType() == 'c') debit(transaction);
        if (transaction.getType() == 'd') credit(transaction);
    }

    private void debit(Transaction transaction){
        balance -= transaction.getValue();
    }

    private void credit(Transaction transaction){
        balance += transaction.getValue();

    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
