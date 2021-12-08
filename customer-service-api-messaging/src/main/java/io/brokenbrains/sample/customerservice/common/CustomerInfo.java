package io.brokenbrains.sample.customerservice.common;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class CustomerInfo {

    @Embedded
    private Name name;

    private String phoneNumber;

    @Embedded
    private Address address;

    private String idNumber;

    private String idType;

    private long merchantId;

    public CustomerInfo() {
    }

    public CustomerInfo(Name name, String phoneNumber, Address address, String idNumber, String idType, long merchantId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.idNumber = idNumber;
        this.idType = idType;
        this.merchantId = merchantId;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() { return idType; }

    public void setIdType(String idType) { this.idType = idType; }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }
}
