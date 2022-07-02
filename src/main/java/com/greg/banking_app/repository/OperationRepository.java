package com.greg.banking_app.repository;

import com.greg.banking_app.domain.CurrencySymbol;
import com.greg.banking_app.domain.Operation;
import com.greg.banking_app.domain.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByOperationDate(LocalDateTime dateTime);
    List<Operation> findByCurrencySymbol(CurrencySymbol currencySymbol);
    List<Operation> findByOperationType(OperationType operationType);
}
