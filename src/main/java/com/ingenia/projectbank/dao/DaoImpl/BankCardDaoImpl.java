package com.ingenia.projectbank.dao.DaoImpl;

import com.ingenia.projectbank.dao.BankCardDao;
import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.BankCard;
import com.ingenia.projectbank.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BankCardDaoImpl implements BankCardDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<BankCard> findBankCardsByUser(User user) {
        User userOpt = manager.find(User.class,user.getId());

        if(userOpt != null){
            List<Account> accounts = userOpt.getAccounts();
            for(Account account: accounts){
               return account.getCards();
            }
        }
        return null;
    }

    @Override
    public List<BankCard> findBankCardsByAccount(Account account) {
        Account accountOpt = manager.find(Account.class,account.getId());

        if(accountOpt!= null){
            List<BankCard> bankCards = accountOpt.getCards();
            return bankCards;
        }
        return null;
    }
}

