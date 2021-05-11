package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCardRepository extends JpaRepository<BankCard,Long> {

}
