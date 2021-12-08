package io.brokenbrains.sample.customerservice.backend;

import io.brokenbrains.sample.customerservice.common.Address;
import io.brokenbrains.sample.customerservice.common.CustomerInfo;
import io.brokenbrains.sample.customerservice.common.Name;

public class CustomerMother {

    public static long merchantId = 1;

    public static CustomerInfo makeCustomer() {
        return new CustomerInfo(
                new Name("John", "Doe"), "011-555-1212",
                new Address("1 high street", null, "Oakland", "CA", "94719"),
                "xxx-yy-zzz", "test", merchantId);
    }
}
