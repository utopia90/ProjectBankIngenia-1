package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.BankCard;
import com.ingenia.projectbank.service.BankCardService;

import java.util.List;
import java.util.Optional;

public class BankCardServiceImpl implements BankCardService {
    @Override
    public List<BankCard> findAllBankCards() {
        return null;
    }

    @Override
    public Optional<BankCard> findOneBankCardById(Long id) {
        return Optional.empty();
    }

    @Override
    public BankCard createBankCard(BankCard bankCard) {
        return null;
    }

    @Override
    public BankCard updateBankCard(BankCard bankCard) {
        return null;
    }

    @Override
    public void deleteOneBankCardById(Long id) {

    }

    @Override
    public void deleteAllBankCards() {

    }
}
