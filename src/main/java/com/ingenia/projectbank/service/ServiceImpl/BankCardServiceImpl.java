package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.BankCard;
import com.ingenia.projectbank.repository.BankCardRepository;
import com.ingenia.projectbank.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BankCardServiceImpl implements BankCardService {

    @Autowired
    BankCardRepository repository;

    @Override
    public List<BankCard> findAllBankCards() {
        return repository.findAll();
    }

    @Override
    public Optional<BankCard> findOneBankCardById(Long id) {
        if(id!=null)repository.findById(id);
        return Optional.empty();
    }

    @Override
    public BankCard createBankCard(BankCard bankCard) {
        return repository.save(bankCard);
    }

    @Override
    public BankCard updateBankCard(BankCard bankCard) {
        if(bankCard.getId()!=null)repository.save(bankCard);
        return null;
    }

    @Override
    public void deleteOneBankCardById(Long id) {
        if(id!=null)repository.deleteById(id);
    }

    @Override
    public void deleteAllBankCards() {
        repository.deleteAll();
    }
}
