package com.example.rinhav2.services;

import com.example.rinhav2.dtos.BankStatementResponse;

public interface CustomerService {
    public BankStatementResponse getBankStatements(Integer customerId);
}
