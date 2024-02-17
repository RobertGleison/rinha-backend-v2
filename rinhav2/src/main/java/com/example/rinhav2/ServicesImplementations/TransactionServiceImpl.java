package com.example.rinhav2.ServicesImplementations;

import com.example.rinhav2.Repositories.CustomerRepository;
import com.example.rinhav2.Repositories.TransactionRepository;
import com.example.rinhav2.dtos.TransactionRequest;
import com.example.rinhav2.dtos.TransactionResponse;
import com.example.rinhav2.services.TransactionService;
import com.example.rinhav2.entities.Customer;
import com.example.rinhav2.entities.Transaction;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private CustomerRepository customerRepository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.transactionRepository = repository;
    }

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest, Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty())  throw new EntityNotFoundException("This customer do not exist in database");
        Transaction t = new Transaction(transactionRequest.value(),
                                        transactionRequest.type(),
                                        transactionRequest.description(),
                                        customer.get());
        if(!transactionValidation(t, customer.get())) throw new ValidationException("this transaction will overpass the limit");
        customer.get().addTransaction(t);
        transactionRepository.save(t);
        return new TransactionResponse(customer.get().getCreditLimit(), customer.get().getBalance());
    }

    private boolean transactionValidation(Transaction transaction, Customer customer){
        if (transaction.getType() == 'd'){
            if(customer.getBalance() - transaction.getValue() < customer.getCreditLimit()) return false;
        }
        return true;
    }
}
