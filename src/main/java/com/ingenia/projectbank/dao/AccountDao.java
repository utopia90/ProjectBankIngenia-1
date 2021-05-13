package com.ingenia.projectbank.dao;

import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.User;
import org.springframework.http.ResponseEntity;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public interface AccountDao {

    Double getCurrentBalanceByAccountId(Long id);

    List<Account> findAccountsByUser(User user);

    Double getAccountBalanceByTypeAndUser(User user, String balanceType);

    ResponseEntity<Void> deleteAccountById(Long id);
}
