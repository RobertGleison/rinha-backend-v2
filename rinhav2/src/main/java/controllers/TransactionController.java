package controllers;

import dtos.TransactionRequest;
import entities.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TransactionService;

@RestController("/clientes")
public class TransactionController {

    private TransactionService service;

    public TransactionController (TransactionService service){
        this.service = service;
    }

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<Transaction> createTransaction(TransactionRequest transactionRequest){
    Transaction transaction = convertTransactionRequestToTransaction(transactionRequest);

    }

    private Transaction convertTransactionRequestToTransaction(TransactionRequest transactionRequest){
        return new Transaction(
                transactionRequest.value(),
                transactionRequest.type(),
                transactionRequest.description());
    }

}
