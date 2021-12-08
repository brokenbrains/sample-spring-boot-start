package io.brokenbrains.sample.accountservice.common;

import io.brokenbrains.sample.commondomain.Money;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.Embeddable;

@Embeddable
public class AccountInfo {
    private String name;
    private Money balance;

    public AccountInfo() {
    }
    public AccountInfo(String name) {
        this.name = name;
    }

    public AccountInfo(String name, Money balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public String getName() {
        return name;
    }

    public Money getBalance() {
        return balance;
    }
}
