package io.brokenbrains.sample.customerservice.common;

public class CreateCustomerResponse {
    private long id;

    public CreateCustomerResponse() {
    }

    public CreateCustomerResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
