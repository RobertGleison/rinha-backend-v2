package services;

import dtos.TransactionRequest;
import dtos.TransactionResponse;

public interface TransactionService {
    public TransactionResponse createTransaction(TransactionRequest transactionRequest, Integer customerId);

}
