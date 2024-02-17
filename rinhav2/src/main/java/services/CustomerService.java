package services;

import dtos.BankStatementResponse;

import java.util.List;

public interface CustomerService {
    public BankStatementResponse getBankStatements(Integer customerId);
}
