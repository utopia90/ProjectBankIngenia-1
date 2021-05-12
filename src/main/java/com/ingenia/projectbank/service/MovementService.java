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
    List<Movement> findMovementsByCategory(CategoryType categoryType);
    List<Movement> findMovementsByOperation(OperationType operationType);
    List<Movement> findMovementsByPayment(PaymentType paymentType);
}
