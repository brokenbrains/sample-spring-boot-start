package io.brokenbrains.sample.customerservice.backend;

import io.brokenbrains.sample.customerservice.common.CustomerInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {
    private CustomerService customerService;
    private CustomerRepository customerRepository;
    @Before
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }

}
