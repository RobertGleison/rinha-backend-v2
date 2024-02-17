package com.example.rinhav2.dtos;

import com.example.rinhav2.entities.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public record BankStatementResponse(
        Integer total,
        LocalDateTime timestamp,
        Integer limit,
        List<Transaction> transactions) {

}
