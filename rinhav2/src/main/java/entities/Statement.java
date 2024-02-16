package entities;

import java.util.List;

public class Statement {
    private Integer balance;
    private List<Transaction> transactions;

    public Statement(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void addTransactions(Transaction transactions) {
        this.transactions.add(transactions);
    }

    public void deleteTransactions(Transaction transactions) {
        this.transactions.remove(transactions);
    }

}
