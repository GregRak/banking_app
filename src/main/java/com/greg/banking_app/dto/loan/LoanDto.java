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
public class LoanDto {

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

    public static final class LoanDtoBuilder{
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

        public LoanDtoBuilder loanId(Long loanId) {
            this.loanId = loanId;
            return this;
        }

        public LoanDtoBuilder startValue(BigDecimal startValue) {
            this.startValue = startValue;
            return this;
        }

        public LoanDtoBuilder currentValue(BigDecimal currentValue) {
            this.currentValue = currentValue;
            return this;
        }

        public LoanDtoBuilder interestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public LoanDtoBuilder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public LoanDtoBuilder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public LoanDtoBuilder currencySymbol(CurrencySymbol currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public LoanDtoBuilder active(boolean active) {
            this.active = active;
            return this;
        }

        public LoanDtoBuilder accountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public LoanDtoBuilder installments(List<InstallmentDto> installments) {
            this.installments = installments;
            return this;
        }

        public LoanDto build() {
            return new LoanDto(
                    loanId, startValue, currentValue, interestRate, startDate, endDate, currencySymbol, active, accountId, installments
            );
        }
    }
}
