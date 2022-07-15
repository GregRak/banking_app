package com.greg.banking_app.dto.loan;

import com.greg.banking_app.enums.CurrencySymbol;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class LoanBaseDto {

    private Long loanId;
    private BigDecimal startValue;
    private BigDecimal currentValue;
    private BigDecimal interestRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int period;
    private CurrencySymbol currencySymbol;
    private boolean active;
    private Long accountId;
}

