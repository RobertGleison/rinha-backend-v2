package entities;

import java.time.LocalDateTime;

public class Transaction {
    private Integer value;
    private Character type;
    private String description;
    private Integer limit;
    private Integer balance;
    private LocalDateTime timeStamp;

    public Transaction(Integer value, Character type, String description, Integer limit, Integer balance) {
        this.value = value;
        this.type = type;
        this.description = description;
        this.limit = limit;
        this.balance = balance;
        this.timeStamp = LocalDateTime.now();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
