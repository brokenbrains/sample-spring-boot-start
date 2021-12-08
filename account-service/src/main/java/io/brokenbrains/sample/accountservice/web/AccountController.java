package io.brokenbrains.sample.accountservice.web;

import io.brokenbrains.sample.accountservice.backend.Account;
import io.brokenbrains.sample.accountservice.backend.AccountService;
import io.brokenbrains.sample.accountservice.common.AccountInfo;
import io.brokenbrains.sample.accountservice.common.CreateAccountResponse;
import io.brokenbrains.sample.accountservice.common.GetAccountResponse;
import io.brokenbrains.sample.accountservice.common.GetAccountsResponse;
import io.brokenbrains.sample.commondomain.AccountState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CreateAccountResponse> createAccount(@Validated @RequestBody AccountInfo accountInfo) {
        logger.info("URL:/api/accounts Method:POST Request= {}", accountInfo);
        ResponseEntity <CreateAccountResponse> response= new ResponseEntity<>(new CreateAccountResponse(accountService.openAccount(accountInfo).getId()),HttpStatus.OK);
        logger.info("URL:/api/accounts Method:POST Response= {}", response);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable long id) {
        logger.info("URL:/api/accounts Method:GET PathVariable= {}", id);
        ResponseEntity <GetAccountResponse> response=accountService.findAccount(id)
                .map(c -> new ResponseEntity<>(new GetAccountResponse(c.getAccountInfo(), c.getState()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        logger.info("URL:/api/accounts Method:GET Response= {}", response);
        return response;
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        accountService.delete(id);
    }

    @GetMapping()
    public ResponseEntity<GetAccountsResponse> getAccounts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        logger.info("URL:/api/accounts Method:GET RequestParam Name= {} Status= {}",name,status);
        Page<Account> returnPage = accountService.findAll(
                new Account(new AccountInfo(name),status != null ? AccountState.valueOf(status):null),
                PageRequest.of(page, size)
        );
        ResponseEntity<GetAccountsResponse> response = new ResponseEntity<>(new GetAccountsResponse(returnPage.getContent(),returnPage.getNumber(),returnPage.getTotalPages(),returnPage.getTotalElements()), HttpStatus.OK);
        logger.info("URL:/api/accounts Method:GET Response= {}", response);
        return  response;
    }



}
