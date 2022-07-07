package com.greg.banking_app.service;

import com.greg.banking_app.domain.Loan;
import com.greg.banking_app.exception.AccountNotFoundException;
import com.greg.banking_app.exception.LoanNotFoundException;
import com.greg.banking_app.repository.AccountRepository;
import com.greg.banking_app.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanDbService {

    private final LoanRepository loanRepository;
    private final AccountRepository accountRepository;

    public List<Loan> getAccountLoans(Long accountId) throws AccountNotFoundException {
        if(accountRepository.existsById(accountId)) {
            return loanRepository.findByAccount_AccountId(accountId);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public Loan getLoan(Long loanId) throws LoanNotFoundException {
        return loanRepository.findById(loanId).orElseThrow(LoanNotFoundException::new);
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deactiveLoan(Long loanId) throws LoanNotFoundException {
        if(loanRepository.existsById(loanId)) {
            Loan currentLoan = loanRepository.findById(loanId).get();
            currentLoan.setActive(false);
            loanRepository.save(currentLoan);
        } else {
            throw new LoanNotFoundException();
        }
    }

    public Loan updateLoan(Loan loan) throws LoanNotFoundException {
        if(loanRepository.existsById(loan.getLoanId())) {
            return loanRepository.save(loan);
        } else {
            throw new LoanNotFoundException();
        }
    }
}
