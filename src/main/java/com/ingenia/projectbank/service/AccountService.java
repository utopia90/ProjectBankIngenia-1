package com.ingenia.projectbank.service;

import com.ingenia.projectbank.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAllAccounts();

    Optional<Account> findOneAccountById(Long id);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    void deleteOneAccountById(Long id);

    void deleteAllAccounts();

}
