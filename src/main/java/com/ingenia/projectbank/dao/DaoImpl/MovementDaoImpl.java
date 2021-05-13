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
import java.util.stream.Stream;

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
        if (firstDay != null&&lastDay!=null) {
            Query query = manager.createQuery("select m FROM Movement m where   m.account.id ="+accountId+" AND m.date between ="+firstDay+"AND"+lastDay );
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsByCategoryAccountId(Long accountId, CategoryType categoryType) {
        //TODO-------------------------- ESTA PENDIENTE BUSCAR UN SQL QUE FUNCIONE PARA REFACTORIZARLO MEJOR
        if (categoryType != null&&accountId!=null) {
            String sql="SELECT m FROM Movement m JOIN Account a on m.account.id = a.id WHERE a.id ="+accountId;
            //String sql="SELECT m FROM Movement m JOIN Account a on m.account.id = a. WHERE m.paymentType ="+paymentType.toString().toLowerCase()+" AND   a.id ="+accountId;
            Query query = manager.createQuery(sql);
            List<Movement> movementList = query.getResultList();
            List<Movement> movementListF =new ArrayList<>();
            for (int i = 0; i < movementList.size(); i++) {
                if(movementList.get(i).getCategoryType().equals(categoryType.toString().toUpperCase())){
                    movementListF.add(movementList.get(i));
                }
            }
            return movementListF;
            //return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsByOperationAccountId(Long accountId, OperationType operationType) {
        //TODO-------------------------- ESTA PENDIENTE BUSCAR UN SQL QUE FUNCIONE PARA REFACTORIZARLO MEJOR
        if (operationType != null&&accountId!=null) {
            String sql="SELECT m FROM Movement m JOIN Account a on m.account.id = a.id WHERE a.id ="+accountId;
            //String sql="SELECT m FROM Movement m JOIN Account a on m.account.id = a. WHERE m.paymentType ="+paymentType.toString().toLowerCase()+" AND   a.id ="+accountId;
            Query query = manager.createQuery(sql);
            List<Movement> movementList = query.getResultList();
            List<Movement> movementListF =new ArrayList<>();
            for (int i = 0; i < movementList.size(); i++) {
                if(movementList.get(i).getOperationType().equals(operationType.toString().toUpperCase())){
                    movementListF.add(movementList.get(i));
                }
            }
            return movementListF;
            //return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsByPaymentAccountId(Long accountId, PaymentType paymentType) {
//TODO-------------------------- ESTA PENDIENTE BUSCAR UN SQL QUE FUNCIONE PARA REFACTORIZARLO MEJOR
        if (paymentType != null&&accountId!=null) {
            String sql="SELECT m FROM Movement m JOIN Account a on m.account.id = a.id WHERE a.id ="+accountId;
            //String sql="SELECT m FROM Movement m JOIN Account a on m.account.id = a. WHERE m.paymentType ="+paymentType.toString().toLowerCase()+" AND   a.id ="+accountId;
            Query query = manager.createQuery(sql);
            List<Movement> movementList = query.getResultList();
            List<Movement> movementListF =new ArrayList<>();
            for (int i = 0; i < movementList.size(); i++) {
                if(movementList.get(i).getPaymentType().equals(paymentType.toString().toUpperCase())){
                    movementListF.add(movementList.get(i));
                }
            }
            return movementListF;
            //return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movement> findMovementsAllAccountId(Long accountId) {
        if (accountId != null) {
            Query query = manager.createQuery("select m FROM Movement m where m.account.id ="+accountId);
            return query.getResultList();
        }
        return new ArrayList<>();
    }
}



