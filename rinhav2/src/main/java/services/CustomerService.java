package services;

import dtos.BankStatementResponse;

public interface CustomerService {
    public BankStatementResponse getBankStatements(Integer id);
}
