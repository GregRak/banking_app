package com.greg.banking_app.dto.account;

import com.greg.banking_app.dto.loan.LoanBaseDto;
import com.greg.banking_app.enums.CurrencySymbol;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountWithLoansDto {

    private Long accountId;
    private Long accountNumber;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
    private BigDecimal presentValue;
    private CurrencySymbol currencySymbol;
    private boolean active;
    private Long userId;
    private List<LoanBaseDto> loans;
}
