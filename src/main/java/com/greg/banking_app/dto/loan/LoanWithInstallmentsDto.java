package com.greg.banking_app.dto.loan;

import com.greg.banking_app.dto.installment.InstallmentDto;
import com.greg.banking_app.enums.CurrencySymbol;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class LoanWithInstallmentsDto {

    private Long loanId;
    private BigDecimal startValue;
    private BigDecimal currentValue;
    private BigDecimal interestRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CurrencySymbol currencySymbol;
    private boolean active;
    private Long accountId;
    private List<InstallmentDto> installments;
}
