package io.brokenbrains.sample.customerservice.backend;

import io.brokenbrains.sample.customerservice.common.CustomerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerInfo customerInfo) {
        Customer customer = new Customer(customerInfo);
        customerRepository.save(customer);
        return customer;
    }

    public Optional<Customer> findCustomer(long id) {
        return customerRepository.findById(id);
    }


}
