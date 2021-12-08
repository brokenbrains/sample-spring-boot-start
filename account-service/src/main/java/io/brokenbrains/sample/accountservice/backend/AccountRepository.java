package io.brokenbrains.sample.accountservice.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AccountRepository extends JpaRepository<Account, Long>, QueryByExampleExecutor<Account> {
}
