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
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ACCOUNT", unique = true)
    private Long accountId;

    @NotNull
    @Column(name = "ACCOUNT_NUMBER", unique = true)
    private Long accountNumber;

    @Column(name = "ACCOUNT_OPEN_DATE")
    private LocalDateTime openDate;

    @Column(name = "ACCOUNT_CLOSE_DATE")
    private LocalDateTime closeDate;

    @NotNull
    @Column(name = "PRESENT_VALUE")
    private BigDecimal presentValue;

    @NotNull
    @Column(name = "CURRENCY")
    private CurrencySymbol currencySymbol;

    @NotNull
    @Column(name = "IS_ACTIVE")
    private boolean active;
}
