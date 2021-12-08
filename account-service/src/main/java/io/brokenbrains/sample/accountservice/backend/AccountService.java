package io.brokenbrains.sample.accountservice.backend;

import io.brokenbrains.sample.accountservice.common.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AccountService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account openAccount(AccountInfo accountInfo) {
        logger.info("AccountService is opening account = {}", accountInfo);
        Account account = new Account(accountInfo);
        accountRepository.save(account);
        logger.info("AccountService created and saved account = {}", account);
        logger.info("AccountService published AccountOpenedEvent for account = {}", account);
        return account;
    }
    public Optional<Account> findAccount(long id) {
        return accountRepository.findById(id);
    }

    public Account update(Long id,AccountInfo accountInfo){
        try {
            Account account = accountRepository.findById(id).get();
            account.updateAccount(accountInfo);
            return  account;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void delete(Long id){
        accountRepository.deleteById(id);
    }

    public Page<Account> findAll(Account account, Pageable pageable){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Account> example = Example.of(account,matcher);
        return accountRepository.findAll(example,pageable);
    }


}
