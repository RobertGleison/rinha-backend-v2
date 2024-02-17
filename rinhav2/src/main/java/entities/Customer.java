package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    //@TODO: Maybe the best type option should be BigDecimal.
    private Integer limit;
    private Integer balance;
    Customer customer;
    private List<Transaction> transactions;

    public Customer(Integer limit, Integer balance, Customer customer) {
        this.limit = limit;
        this.balance = balance;
        this.customer = customer;
    }

    public int getId() {
        return Id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getValue();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Customer getCustomer(){
        return customer;
    }

}
