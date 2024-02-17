package controllers;

import dtos.TransactionRequest;
import dtos.TransactionResponse;
import entities.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.TransactionService;

import java.net.URI;

@RestController("/clientes")
public class TransactionController {

    private TransactionService service;

    public TransactionController (TransactionService service){
        this.service = service;
    }

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransactionResponse> createTransaction(TransactionRequest transactionRequest, @PathVariable Integer customerId){
//
        return ResponseEntity.ok().body(service.createTransaction(transactionRequest, customerId));
    }
//
//    private Transaction convertTransactionRequestToTransaction(TransactionRequest transactionRequest){
//        return new Transaction(
//                transactionRequest.value(),
//                transactionRequest.type(),
//                transactionRequest.description());
//    }

}
