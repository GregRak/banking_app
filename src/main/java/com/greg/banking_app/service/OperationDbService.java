package com.greg.banking_app.service;

import com.greg.banking_app.domain.Operation;
import com.greg.banking_app.enums.OperationType;
import com.greg.banking_app.exception.AccountNotFoundException;
import com.greg.banking_app.exception.OperationNotFoundException;
import com.greg.banking_app.repository.AccountRepository;
import com.greg.banking_app.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationDbService {

    private final OperationRepository operationRepository;
    private final AccountRepository accountRepository;

    public List<Operation> getAccountOperations(Long accountId) throws AccountNotFoundException {
        if(accountRepository.existsById(accountId)) {
            return operationRepository.findByAccount_AccountId(accountId);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public Operation getOperation(Long operationId) throws OperationNotFoundException {
        return operationRepository.findById(operationId).orElseThrow(OperationNotFoundException::new);
    }

    public List<Operation> getAccountDateRangeOperations(
            Long accountId, LocalDateTime rangeStart, LocalDateTime rangeEnd) throws AccountNotFoundException {
        if(accountRepository.existsById(accountId)) {
            return operationRepository.findByAccount_AccountIdAndOperationDateIsBetweenOrderByOperationDate(
                    accountId, rangeStart, rangeEnd
            );
        } else {
            throw new AccountNotFoundException();
        }
    }

    public List<Operation> getAccountFromDateAndTypeOperations(
            Long accountId, LocalDateTime fromDate, OperationType operationType) throws AccountNotFoundException {
        if(accountRepository.existsById(accountId)) {
            return operationRepository.findByAccount_AccountIdAndOperationDateAfterAndOperationType(
                    accountId, fromDate, operationType
            );
        } else {
            throw new AccountNotFoundException();
        }
    }

    public List<Operation> getOperationOfTheDay(Long accountId, LocalDateTime date) throws AccountNotFoundException {
        if(accountRepository.existsById(accountId)) {
            return operationRepository.findByAccount_AccountIdAndOperationDate(accountId, date);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public Operation createOperation(Operation operation) throws OperationNotFoundException {
        if(operationRepository.existsById(operation.getOperationId())) {
            return operationRepository.save(operation);
        } else {
            throw new OperationNotFoundException();
        }
    }
}
