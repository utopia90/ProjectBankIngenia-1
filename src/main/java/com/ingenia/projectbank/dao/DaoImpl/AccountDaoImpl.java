package com.ingenia.projectbank.dao.DaoImpl;

import com.ingenia.projectbank.dao.AccountDao;
import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.User;
import org.hibernate.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
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
    /*@Override
    public Query getAccountBalance(Account account, String balanceType) {
        return null;
    }*/
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

}
