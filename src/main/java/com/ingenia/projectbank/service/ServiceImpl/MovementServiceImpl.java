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
    public List<Movement> findMovementsInterval(Date firstDay, Date lastDay) {
        return movementDao.findMovementsInterval(firstDay,lastDay);
    }

    @Override
    public List<Movement> findMovementsByCategory(CategoryType categoryType) {
        return movementDao.findMovementsByCategory(categoryType);
    }

    @Override
    public List<Movement> findMovementsByOperation(OperationType operationType) {
        return movementDao.findMovementsByOperation(operationType);
    }

    @Override
    public List<Movement> findMovementsByPayment(PaymentType paymentType) {
        return movementDao.findMovementsByPayment(paymentType);
    }
}
