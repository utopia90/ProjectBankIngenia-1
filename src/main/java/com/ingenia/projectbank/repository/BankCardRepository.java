package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard,Long> {

}
