package ServicesImplementations;

import Repositories.CustomerRepository;
import Repositories.TransactionRepository;
import dtos.TransactionRequest;
import dtos.TransactionResponse;
import entities.Customer;
import entities.Transaction;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import services.TransactionService;

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
        customer.get().addTransaction(t);
        transactionRepository.save(t);
        return new TransactionResponse(customer.get().getLimit(), customer.get().getBalance());
    }
}
