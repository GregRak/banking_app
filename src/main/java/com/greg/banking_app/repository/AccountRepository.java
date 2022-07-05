package com.greg.banking_app.repository;

import com.greg.banking_app.domain.Account;
import com.greg.banking_app.enums.CurrencySymbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByActive(boolean active);

    List<Account> findByCurrencySymbol(CurrencySymbol currencySymbol);
}
