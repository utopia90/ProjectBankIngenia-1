package com.ingenia.projectbank.dao.DaoImpl;

import com.ingenia.projectbank.dao.MovementDao;
import com.ingenia.projectbank.model.CategoryType;
import com.ingenia.projectbank.model.Movement;
import com.ingenia.projectbank.model.OperationType;
import com.ingenia.projectbank.model.PaymentType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovementDaoImpl implements MovementDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Movement> findMovementsInterval(Date firstDay, Date lastDay) {
      if (firstDay != null && lastDay != null) {
        //  Query query = manager.createQuery("SELECT e FROM Movement AS e WHERE e.date BE");
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
}



