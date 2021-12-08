package io.brokenbrains.sample.accountservice.backend;

import io.brokenbrains.sample.accountservice.common.AccountInfo;
import org.junit.Before;
import org.junit.Test;


import static io.brokenbrains.sample.accountservice.backend.AccountMother.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class AccountServiceTest {
    private AccountService accountService;
    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void shouldOpenAccount() {
        when(accountRepository.save(any(Account.class))).then(invocation -> {
            ((Account) invocation.getArguments()[0]).setId(accountId);
            return null;
        });

        AccountInfo accountInfo = new AccountInfo("Checking", initialBalance);
        Account account = accountService.openAccount(accountInfo);
        verify(accountRepository).save(account);
    }
}