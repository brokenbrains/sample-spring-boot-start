package io.brokenbrains.sample.accountservice.common;

import io.brokenbrains.sample.commondomain.AccountState;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class GetAccountResponse {
    private AccountInfo accountInfo;
    private AccountState state;

    private GetAccountResponse() {
    }

    public GetAccountResponse(AccountInfo accountInfo, AccountState state) {
        this.accountInfo = accountInfo;
        this.state = state;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
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
}
