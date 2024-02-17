package controllers;

import dtos.BankStatementResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.CustomerService;

@RestController("/clientes")
public class BankStatementController {

    private CustomerService customerService;

    public BankStatementController (CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity <BankStatementResponse> getBankStatements(@PathVariable Integer customerId){
        return ResponseEntity.ok().body(customerService.getBankStatements(customerId));
    }
}
