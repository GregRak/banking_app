package com.greg.banking_app.repository;

import com.greg.banking_app.domain.CurrencySymbol;
import com.greg.banking_app.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByInterestRate(BigDecimal interestRate);
    List<Loan> findByCurrencySymbol(CurrencySymbol currencySymbol);
}
