package io.brokenbrains.sample.accountservice.backend;

import io.brokenbrains.sample.accountservice.common.AccountInfo;
import io.brokenbrains.sample.commondomain.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AccountTest {
    private Account aggregate;

    @Test
    public void shouldOpen() {
        AccountInfo accountInfo = AccountMother.makeAccount();
        Money initialBalance = accountInfo.getBalance();
        openAccount(accountInfo);
        assertEquals(initialBalance, aggregate.getAccountInfo().getBalance());
    }

    private void openAccount(AccountInfo accountInfo) {
        aggregate = new Account(accountInfo);
    }

}
