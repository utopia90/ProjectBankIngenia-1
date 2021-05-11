package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.repository.AccountRepository;
import com.ingenia.projectbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl  implements AccountService {

    @Autowired
    AccountRepository repository;



    @Override
    public List<Account> findAllAccounts() {
        return repository.findAll();
    }

    @Override
    public Optional<Account> findOneAccountById(Long id) {
        if(id!=null)return findOneAccountById(id);
        return Optional.empty();
    }

    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
    if(account.getId()!=null)return repository.save(account);
        return null;
    }

    @Override
    public void deleteOneAccountById(Long id) {
        if(id!=null)repository.deleteById(id);
    }

    @Override
    public void deleteAllAccounts() {
        repository.deleteAll();
    }
}
