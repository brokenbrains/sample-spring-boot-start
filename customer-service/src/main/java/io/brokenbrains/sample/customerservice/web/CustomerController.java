package io.brokenbrains.sample.customerservice.web;

import io.brokenbrains.sample.customerservice.backend.CustomerService;
import io.brokenbrains.sample.customerservice.common.CreateCustomerResponse;
import io.brokenbrains.sample.customerservice.common.CustomerInfo;
import io.brokenbrains.sample.customerservice.common.GetCustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Validated @RequestBody CustomerInfo customerInfo) {
        logger.info("URL:/api/customers Method:POST Request= {}", customerInfo);
        ResponseEntity<CreateCustomerResponse> response = new ResponseEntity<>(new CreateCustomerResponse(customerService.createCustomer(customerInfo).getId()), HttpStatus.OK);
        logger.info("URL:/api/customers Method:POST Response= {}", response);
        return response;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable long id) {
        logger.info("URL:/api/customers Method:GET PathVariable= {}", id);
        ResponseEntity<GetCustomerResponse> response = customerService.findCustomer(id)
                .map(c -> new ResponseEntity<>(new GetCustomerResponse(c.getCustomerInfo()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        logger.info("URL:/api/customers Method:GET Response= {}", response);
        return response;
    }

}
