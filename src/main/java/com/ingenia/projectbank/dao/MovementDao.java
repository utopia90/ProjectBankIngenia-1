package com.ingenia.projectbank.dao;

import com.ingenia.projectbank.model.CategoryType;
import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.model.OperationType;
import com.ingenia.projectbank.model.PaymentType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MovementDao {
    List<Movement> findMovementsInterval(Instant firstDay, Instant lastDay);
    List<Movement> findMovementsByCategory(String categoryType);
    List<Movement> findMovementsByOperation(String operationType);
    List<Movement> findMovementsByPayment(String paymentType);

    List<Movement> findMovementsIntervalByAccountId(Long accountId,Instant firstDay, Instant lastDay);
    List<Movement> findMovementsByCategoryAccountId(Long accountId,String categoryType);
    List<Movement> findMovementsByOperationAccountId(Long accountId,String operationType);
    List<Movement> findMovementsByPaymentAccountId(Long accountId,String paymentType);
    List<Movement> findMovementsAllAccountId(Long accountId);
}
