package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.dao.MovementDao;
import com.ingenia.projectbank.model.CategoryType;
import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.model.OperationType;
import com.ingenia.projectbank.model.PaymentType;
import com.ingenia.projectbank.repository.AccountRepository;
import com.ingenia.projectbank.repository.MovementRepository;
import com.ingenia.projectbank.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class MovementServiceImpl  implements MovementService {

    @Autowired
    MovementRepository movementRepository;

    @Autowired
    MovementDao movementDao;

    @Override
    public List<Movement> findAllMovements() {
        return movementRepository.findAll();
    }

    @Override
    public Optional<Movement> findOneMovementById(Long id) {
        if(id!=null)return movementRepository.findById(id);
        return Optional.empty();
    }

    @Override
    public Movement createMovement(Movement movement) {
        movement.getAccount().addMovimiento(movement);
        return movementRepository.save(movement);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        if(movement.getId()!=null)movementRepository.save(movement);
        return null;
    }

    @Override
    public void deleteOneMovementById(Long id) {
        if(id!=null)movementRepository.deleteById(id);
    }

    @Override
    public void deleteAllMovements() {
        movementRepository.deleteAll();
    }

    @Override
    public List<Movement> findMovementsInterval(Instant firstDay, Instant lastDay) {
        return movementDao.findMovementsInterval(firstDay,lastDay);
    }

    @Override
    public List<Movement> findMovementsByCategory(String categoryType) {
        switch(categoryType.toUpperCase()) {
            case "RESTAURANTS":
                return movementDao.findMovementsByCategory(CategoryType.RESTAURANTS);
            case "FUEL":
                return movementDao.findMovementsByCategory(CategoryType.FUEL);
            case "CLOTHES":
                return movementDao.findMovementsByCategory(CategoryType.CLOTHES);
            case "UTILITIES":
                return movementDao.findMovementsByCategory(CategoryType.UTILITIES);
            case "PAID":
                return movementDao.findMovementsByCategory(CategoryType.PAID);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public List<Movement> findMovementsByOperation(String operationType) {
        switch(operationType.toUpperCase()) {
            case "SUM":
                return movementDao.findMovementsByOperation(OperationType.SUM);
            case "REST":
                return movementDao.findMovementsByOperation(OperationType.REST);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public List<Movement> findMovementsByPayment(String paymentType) {
        switch(paymentType.toUpperCase()) {
            case "CARD":
                return movementDao.findMovementsByPayment(PaymentType.CARD);
            case "ACCOUNT":
                return movementDao.findMovementsByPayment(PaymentType.ACCOUNT);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public List<Movement> findMovementsIntervalByAccountId(Long accountId, Instant firstDay, Instant lastDay) {
        return movementDao.findMovementsIntervalByAccountId(accountId,firstDay,lastDay);
    }

    @Override
    public List<Movement> findMovementsByCategoryAccountId(Long accountId, String categoryType) {
        switch(categoryType.toUpperCase()) {
            case "RESTAURANTS":
                return movementDao.findMovementsByCategoryAccountId(accountId,CategoryType.RESTAURANTS);
            case "FUEL":
                return movementDao.findMovementsByCategoryAccountId(accountId,CategoryType.FUEL);
            case "CLOTHES":
                return movementDao.findMovementsByCategoryAccountId(accountId,CategoryType.CLOTHES);
            case "UTILITIES":
                return movementDao.findMovementsByCategoryAccountId(accountId,CategoryType.UTILITIES);
            case "PAID":
                return movementDao.findMovementsByCategoryAccountId(accountId,CategoryType.PAID);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public List<Movement> findMovementsByOperationAccountId(Long accountId, String operationType) {

        switch(operationType.toUpperCase()) {
            case "SUM":
                return movementDao.findMovementsByOperationAccountId(accountId,OperationType.SUM);
            case "REST":
                return movementDao.findMovementsByOperationAccountId(accountId,OperationType.REST);
            default:
                return new ArrayList<>();
        }

    }

    @Override
    public List<Movement> findMovementsByPaymentAccountId(Long accountId, String paymentType) {
        switch(paymentType.toUpperCase()) {
            case "CARD":
                return movementDao.findMovementsByPaymentAccountId(accountId,PaymentType.CARD);
            case "ACCOUNT":
                return movementDao.findMovementsByPaymentAccountId(accountId,PaymentType.ACCOUNT);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public List<Movement> findMovementsAllAccountId(Long accountId) {
        return movementDao.findMovementsAllAccountId(accountId);
    }
}
