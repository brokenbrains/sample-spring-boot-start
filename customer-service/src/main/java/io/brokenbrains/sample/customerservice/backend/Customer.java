package io.brokenbrains.sample.customerservice.backend;

import io.brokenbrains.sample.customerservice.common.CustomerInfo;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Access(AccessType.FIELD)
public class Customer  {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private CustomerInfo customerInfo;

    private Customer() {
    }

    public Customer(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }



    public Long getId() {
        return id;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }
}
