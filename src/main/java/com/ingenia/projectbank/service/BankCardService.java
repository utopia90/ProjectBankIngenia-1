package com.ingenia.projectbank.service;

import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.BankCard;

import java.util.List;
import java.util.Optional;

public interface BankCardService {

    List<BankCard> findAllBankCards();

    Optional<BankCard> findOneBankCardById(Long id);

    BankCard createBankCard(BankCard bankCard);

    BankCard updateBankCard(BankCard bankCard);

    void deleteOneBankCardById(Long id);

    void deleteAllBankCards();
}
