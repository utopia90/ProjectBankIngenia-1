package com.ingenia.projectbank.service;

import com.ingenia.projectbank.model.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MovementService {

    List<Movement> findAllMovements();

    Optional<Movement> findOneMovementById(Long id);

    Movement createMovement(Movement movement);

    Movement updateMovement(Movement movement);

    void deleteOneMovementById(Long id);

    void deleteAllMovements();
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
