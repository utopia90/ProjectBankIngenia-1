package com.ingenia.projectbank.dao.DaoImpl;

import com.ingenia.projectbank.dao.MovementDao;
import com.ingenia.projectbank.model.CategoryType;
import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.model.OperationType;
import com.ingenia.projectbank.model.PaymentType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class MovementDaoImpl implements MovementDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Movement> findMovementsInterval(Instant firstDay, Instant lastDay) {
      if (firstDay != null && lastDay != null) {
          //Timestamp timestampstart = Timestamp.from(firstDay);
          //Timestamp timestampfinish = Timestamp.from(lastDay);
          Query query = manager.createQuery("SELECT * FROM Movement WHERE date BETWEEN "+firstDay+" AND "+lastDay);
         return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsByCategory(CategoryType categoryType) {
        if(categoryType!=null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Movement> criteria = builder.createQuery(Movement.class);
            Root<Movement> root = criteria.from(Movement.class);
            criteria.select(root);
            criteria.where(builder.equal(root.get("categoryType"),categoryType));
            Query query = manager.createQuery(criteria);
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }


    @Override
    public List<Movement> findMovementsByOperation(OperationType operationType) {
        if(operationType!=null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Movement> criteria = builder.createQuery(Movement.class);
            Root<Movement> root = criteria.from(Movement.class);
            criteria.select(root);
            criteria.where(builder.equal(root.get("operationType"),operationType));
            Query query = manager.createQuery(criteria);
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsByPayment(PaymentType paymentType) {
        if(paymentType!=null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Movement> criteria = builder.createQuery(Movement.class);
            Root<Movement> root = criteria.from(Movement.class);
            criteria.select(root);
            criteria.where(builder.equal(root.get("paymentType"),paymentType));
            Query query = manager.createQuery(criteria);
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsIntervalByAccountId(Long accountId, Instant firstDay, Instant lastDay) {
        return null;
    }

    @Override
    public List<Movement> findMovementsByCategoryAccountId(Long accountId, CategoryType categoryType) {
        return null;
    }

    @Override
    public List<Movement> findMovementsByOperationAccountId(Long accountId, OperationType operationType) {
        return null;
    }

    @Override
    public List<Movement> findMovementsByPaymentAccountId(Long accountId, PaymentType paymentType) {
        return null;
    }

    @Override
    public List<Movement> findMovementsAllAccountId(Long accountId) {
        if (accountId != null) {
            String consulta="select m FROM Movement m JOIN m.account a WHERE a.id = 2";
            Query query = manager.createQuery(consulta);
            System.out.println("----------------------------------------------");
            System.out.println(query.getResultList());
            System.out.println(consulta);
            System.out.println("----------------------------------------------");
            return query.getResultList();
        }
        return new ArrayList<>();
    }
}



