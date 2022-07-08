package com.greg.banking_app.service;

import com.greg.banking_app.domain.Installment;
import com.greg.banking_app.exception.InstallmentNotFoundException;
import com.greg.banking_app.exception.LoanNotFoundException;
import com.greg.banking_app.repository.InstallmentRepository;
import com.greg.banking_app.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstallmentDbService {

    private final InstallmentRepository installmentRepository;
    private final LoanRepository loanRepository;

    public List<Installment> getLoanInstallments(final Long loanId) throws LoanNotFoundException {
        if(loanRepository.existsById(loanId)) {
            return installmentRepository.findByLoan_LoanId(loanId);
        } else {
            throw new LoanNotFoundException();
        }
    }

    public Installment getInstallment(final Long installmentId) throws InstallmentNotFoundException {
        return installmentRepository.findById(installmentId).orElseThrow(InstallmentNotFoundException::new);
    }

    public Installment updateInstallment(final Installment installment) throws InstallmentNotFoundException {
        if(installmentRepository.existsById(installment.getInstallmentId())) {
            return installmentRepository.save(installment);
        } else {
            throw new InstallmentNotFoundException();
        }
    }

    public void createInstallment(final Installment installment) {
        installmentRepository.save(installment);
    }
}
