package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.service.MovementService;

import java.util.List;
import java.util.Optional;

public class MovementServiceImpl  implements MovementService {
    @Override
    public List<Movement> findAllMovements() {
        return null;
    }

    @Override
    public Optional<Movement> findOneMovementById(Long id) {
        return Optional.empty();
    }

    @Override
    public Movement createAccount(Movement movement) {
        return null;
    }

    @Override
    public Movement updateAccount(Movement movement) {
        return null;
    }

    @Override
    public void deleteOneMovementById(Long id) {

    }

    @Override
    public void deleteAllMovements() {

    }
}
