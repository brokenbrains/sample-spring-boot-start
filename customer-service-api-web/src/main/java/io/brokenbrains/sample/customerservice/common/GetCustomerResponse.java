package io.brokenbrains.sample.customerservice.common;

public class GetCustomerResponse {
    private CustomerInfo customerInfo;

    public GetCustomerResponse() {
    }

    public GetCustomerResponse(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;

    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}
