package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer value;
    private Character type;
    private String description;
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
