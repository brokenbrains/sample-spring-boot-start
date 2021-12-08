package io.brokenbrains.sample.accountservice.backend;

import io.brokenbrains.sample.accountservice.common.AccountInfo;
import io.brokenbrains.sample.commondomain.AccountState;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Access(AccessType.FIELD)
public class Account  {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountState state;

    @Embedded
    private AccountInfo accountInfo;

    private Date acceptDateTime;
    private Date modifyDateTime;

    private Account() {
    }

    public Account(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        this.state = AccountState.OPEN;
        this.acceptDateTime = new Date();
    }
    public Account(AccountInfo accountInfo,AccountState status) {
        this.accountInfo = accountInfo;
        this.state = status;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }


    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public AccountState getState() {
        return state;
    }

    public Date getAcceptDateTime() {
        return acceptDateTime;
    }

    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    public void updateAccount(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        this.modifyDateTime = new Date();
    }
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
