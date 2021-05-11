package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement,Long> {
}
