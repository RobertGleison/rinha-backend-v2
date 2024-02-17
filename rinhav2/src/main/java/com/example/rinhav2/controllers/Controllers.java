package com.example.rinhav2.controllers;

import com.example.rinhav2.dtos.TransactionRequest;
import com.example.rinhav2.dtos.TransactionResponse;
import com.example.rinhav2.services.CustomerService;
import com.example.rinhav2.dtos.BankStatementResponse;
import com.example.rinhav2.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/clientes")
public class Controllers {

    private CustomerService customerService;
    private TransactionService transactionService;

    public Controllers(CustomerService customerService, TransactionService transactionService){
        this.customerService = customerService;
        this.transactionService= transactionService;
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity <BankStatementResponse> getBankStatements(@PathVariable Integer customerId){
        return ResponseEntity.ok().body(customerService.getBankStatements(customerId));
    }

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransactionResponse> createTransaction(TransactionRequest transactionRequest, @PathVariable Integer customerId){
        return ResponseEntity.ok().body(transactionService.createTransaction(transactionRequest, customerId));
    }
}
