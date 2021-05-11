package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.repository.MovementRepository;
import com.ingenia.projectbank.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovementServiceImpl  implements MovementService {

    @Autowired
    MovementRepository repository;

    @Override
    public List<Movement> findAllMovements() {
        return repository.findAll();
    }

    @Override
    public Optional<Movement> findOneMovementById(Long id) {
        if(id!=null)return repository.findById(id);
        return Optional.empty();
    }

    @Override
    public Movement createMovement(Movement movement) {
        return repository.save(movement);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        if(movement.getId()!=null)repository.save(movement);
        return null;
    }

    @Override
    public void deleteOneMovementById(Long id) {
        if(id!=null)repository.deleteById(id);
    }

    @Override
    public void deleteAllMovements() {
        repository.deleteAll();
    }
}
