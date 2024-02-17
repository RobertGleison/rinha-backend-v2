package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    //@TODO: Maybe the best type option should be BigDecimal.
    @NotBlank
    private Integer limit;
    @NotBlank
    private Integer balance;

    private List<Transaction> transactions;

    public Customer(Integer limit, Integer balance) {
        this.limit = limit;
        this.balance = balance;
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
