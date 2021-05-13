package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.dao.AccountDao;
import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.User;
import com.ingenia.projectbank.repository.AccountRepository;
import com.ingenia.projectbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl  implements AccountService {

    @Autowired
    AccountRepository repository;

    @Autowired
    AccountDao accountDao;


    @Override
    public List<Account> findAllAccounts() {
        return repository.findAll();
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        if(id!=null)return this.repository.findById(id);
        return null;
    }

    @Override
    public Optional<Account> findAccountByIban(String iban) {
            return repository.findAccountByIban(iban);
    }

    @Override
    public Account createAccount(Account account) {
        if (!ObjectUtils.isEmpty(account)) {
            if (repository.existsAccountByIban(account.getIban())) {
                return null;
            }
            return repository.save(account);
        }
        return null;
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

   /* @Override
    public Optional<Account> getAccountBalance(Account account, String balanceType) {
        return Optional.empty();
    }*/

    @Override
    public Double getCurrentBalanceByAccountId(Long id) {
        return this.accountDao.getCurrentBalanceByAccountId(id);
    }

    @Override
    public List<Account> findAccountsByUser(User user) {

        return this.accountDao.findAccountsByUser(user);
    }
}
