package com.ingenia.projectbank.dao.DaoImpl;

import com.ingenia.projectbank.dao.AccountDao;
import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.BankCard;
import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.model.User;
import org.hibernate.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Double getCurrentBalanceByAccountId(Long id) {
        if (id == null) {
            throw new EntityNotFoundException("Can't find Account by ID "
                    + id);
        }else{
            Account account = manager.find(Account.class, id);
            return account.getCurrentBalance();

    }

}

    @Override
    public List<Account> findAccountsByUser(User user) {
        User userOpt = manager.find(User.class,user.getId());

        if(userOpt != null){
            return userOpt.getAccounts();
        }else{
            return null;
        }
    }

    @Override
    public Double getAccountBalanceByTypeAndUser(User user, String balanceType) {
        User userOpt = manager.find(User.class,user.getId());
        List<Account> accounts = userOpt.getAccounts();
        Double totalBalance = 0.00;

        if(userOpt != null){
            switch (balanceType){
                case "credit":
                    for(Account account: accounts){
                        totalBalance += account.getCurrentCreditCardBalance();
                        return totalBalance;
                    }
                case "debit":
                    for(Account account: accounts){
                        totalBalance += account.getCurrentBalance();
                        return totalBalance;
                    }
                case "account":
                    for(Account account: accounts){
                        totalBalance += account.getCurrentBalance();
                        return totalBalance;
                    }
                case "global":
                    for(Account account: accounts) {
                        totalBalance += account.getCurrentGlobalBalance();
                        return totalBalance;
                    }
            }
        }
      return null;
    }

    @Override
    public ResponseEntity<Void> deleteAccountById(Long id) {

        Account account = manager.find(Account.class, id);
        Query queryNative = (Query) manager.createNativeQuery("delete from users_accounts where accounts_id ="+id);

        if (account != null) {
                queryNative.executeUpdate();
                manager.remove(account);
                manager.flush();
            }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void>  deleteAllAccounts() {
        Query queryNative1 = (Query) manager.createNativeQuery("DELETE * from users_accounts");
        Query queryNative2 = (Query) manager.createNativeQuery("DELETE * from Account");

        queryNative1.executeUpdate();
        queryNative2.executeUpdate();

        return ResponseEntity.noContent().build();

    }

}
