package com.greg.banking_app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "LOANS")
public class Loan {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_LOAN", unique = true)
    private Long loanId;

    @NotNull
    @Column(name = "START_VALUE")
    private BigDecimal startValue;

    @NotNull
    @Column(name = "CURRENT_VALUE")
    private BigDecimal currentValue;

    @NotNull
    @Column(name = "INTEREST_RATE")
    private BigDecimal interestRate;

    @NotNull
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "CURRENCY")
    private CurrencySymbol currencySymbol;
}
