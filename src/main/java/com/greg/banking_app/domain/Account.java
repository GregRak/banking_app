package com.greg.banking_app.domain;

import com.greg.banking_app.enums.CurrencySymbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "account",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Loan> loans;

    @OneToMany(
            targetEntity = Operation.class,
            mappedBy = "account",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Operation> operations;

    public Account(Long accountId, Long accountNumber, LocalDateTime openDate, LocalDateTime closeDate, BigDecimal presentValue, CurrencySymbol currencySymbol, boolean active, User user) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.presentValue = presentValue;
        this.currencySymbol = currencySymbol;
        this.active = active;
        this.user = user;
    }
}
