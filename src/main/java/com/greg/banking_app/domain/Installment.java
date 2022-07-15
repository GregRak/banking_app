package com.greg.banking_app.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Table(name = "INSTALLMENTS")
public class Installment {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_INSTALLMENT", unique = true)
    private Long installmentId;

    @NotNull
    @Column(name = "INSTALLMENT_VALUE")
    private BigDecimal installmentValue;

    @NotNull
    @Column(name = "LEFT_TO_PAY")
    private BigDecimal leftToPay;

    @NotNull
    @Column(name = "DUE_DATE")
    private LocalDateTime dueDate;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @NotNull
    @Column(name = "IS_PAID")
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "ID_LOAN")
    private Loan loan;

    public Installment(BigDecimal installmentValue, LocalDateTime dueDate, Loan loan) {
        this.installmentValue = installmentValue;
        this.leftToPay = installmentValue;
        this.dueDate = dueDate;
        this.paymentDate = null;
        this.paid = false;
        this.loan = loan;
    }
}