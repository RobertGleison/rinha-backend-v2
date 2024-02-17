package com.example.rinhav2.services;

import com.example.rinhav2.dtos.TransactionRequest;
import com.example.rinhav2.dtos.TransactionResponse;

public interface TransactionService {
    public TransactionResponse createTransaction(TransactionRequest transactionRequest, Integer customerId);

}
