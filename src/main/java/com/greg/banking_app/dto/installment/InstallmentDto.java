package com.greg.banking_app.dto.installment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InstallmentDto {

    private Long installmentId;
    private BigDecimal installmentValue;
    private BigDecimal leftToPay;
    private LocalDateTime dueDate;
    private LocalDateTime paymentDate;
    private boolean paid;
    private Long loanId;
}
