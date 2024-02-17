package ServicesImplementations;

import Repositories.CustomerRepository;
import dtos.BankStatementResponse;
import entities.Customer;
import entities.Transaction;
import org.springframework.stereotype.Service;
import services.CustomerService;

import java.time.LocalDateTime;
import java.util.List;
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
        if(c.isEmpty()) throw new RuntimeException("This customer do not exist");
        return new BankStatementResponse(c.get().getBalance(),
                LocalDateTime.now(),
                c.get().getLimit(),
                c.get().getTransactions());
    }
}
