package dtos;

import entities.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public record BankStatementResponse(
        Integer total,
        LocalDateTime timestamp,
        Integer limit,
        List<Transaction> transactions
) {
}
