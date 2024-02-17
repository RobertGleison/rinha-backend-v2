package com.example.rinhav2.ServicesImplementations;

import com.example.rinhav2.Repositories.CustomerRepository;
import com.example.rinhav2.services.CustomerService;
import com.example.rinhav2.dtos.BankStatementResponse;
import com.example.rinhav2.entities.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public BankStatementResponse getBankStatements(Integer customerId) {
        Optional<Customer> c = customerRepository.findById(customerId);
        if(c.isEmpty()) throw new EntityNotFoundException("This customer do not exist in database");
        return new BankStatementResponse(c.get().getBalance(),
                LocalDateTime.now(),
                c.get().getCreditLimit(),
                c.get().getTransactions());
    }
}
