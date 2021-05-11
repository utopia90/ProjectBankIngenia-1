package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl  implements AccountService {
    @Override
    public List<Account> findAllAccounts() {
        return null;
    }

    @Override
    public Optional<Account> findOneAccountById(Long id) {
        return Optional.empty();
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public void deleteOneAccountById(Long id) {

    }

    @Override
    public void deleteAllAccounts() {

    }
}
