package dtos;

import entities.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;

public record BankStatementResponse(
        Integer total,
        LocalDateTime timestamp,
        Integer limit,
        List<Transaction> transactions) {

}
