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

    @NotNull
    @Column(name = "IS_ACTIVE")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "ID_ACCOUNT")
    private Account account;

    @OneToMany(
            targetEntity = Installment.class,
            mappedBy = "loan",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Installment> installments;

    public Loan(Long loanId, BigDecimal startValue, BigDecimal currentValue, BigDecimal interestRate, LocalDateTime startDate, LocalDateTime endDate, CurrencySymbol currencySymbol, boolean active, Account account) {
        this.loanId = loanId;
        this.startValue = startValue;
        this.currentValue = currentValue;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currencySymbol = currencySymbol;
        this.active = active;
        this.account = account;
    }
}
