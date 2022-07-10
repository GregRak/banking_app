package com.greg.banking_app.mapper;

import com.greg.banking_app.domain.Account;
import com.greg.banking_app.domain.Loan;
import com.greg.banking_app.dto.loan.LoanDto;
import com.greg.banking_app.exception.AccountNotFoundException;
import com.greg.banking_app.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanMapper {

    private AccountRepository accountRepository;
    private InstallmentMapper installmentMapper;

    public Loan mapToLoan(final LoanDto loanDto) throws AccountNotFoundException {
        Account currentAccount = accountRepository.findById(loanDto.getAccountId()).orElseThrow(AccountNotFoundException::new);
        return new Loan(
                loanDto.getLoanId(),
                loanDto.getStartValue(),
                loanDto.getCurrentValue(),
                loanDto.getInterestRate(),
                loanDto.getStartDate(),
                loanDto.getEndDate(),
                loanDto.getCurrencySymbol(),
                loanDto.isActive(),
                currentAccount
        );
    }

    public LoanDto mapToLoanDto(final Loan loan) {
        return new LoanDto.LoanDtoBuilder()
                .loanId(loan.getLoanId())
                .startValue(loan.getStartValue())
                .currentValue(loan.getCurrentValue())
                .interestRate(loan.getInterestRate())
                .startDate(loan.getStartDate())
                .endDate(loan.getEndDate())
                .currencySymbol(loan.getCurrencySymbol())
                .active(loan.isActive())
                .accountId(loan.getAccount().getAccountId())
                .installments(installmentMapper.mapToInstallmentDtoList(loan.getInstallments()))
                .build();
    }

    public List<LoanDto> mapToLoanDtoList(final List<Loan> list) {
        return list.stream()
                .map(this::mapToLoanDto)
                .collect(Collectors.toList());
    }
}
