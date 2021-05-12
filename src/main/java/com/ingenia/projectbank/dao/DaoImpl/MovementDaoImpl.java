package com.ingenia.projectbank.dao.DaoImpl;

import com.ingenia.projectbank.dao.MovementDao;
import com.ingenia.projectbank.model.Movement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovementDaoImpl implements MovementDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Movement> findMovementsInterval(Date firstDay, Date lastDay) {
        if (firstDay != null || lastDay != null) {
        //    Query query = manager.createQuery("select c FROM Movement WHERE c ");
         //    return query.getResultList();
        }
        return new ArrayList<>();
    }
    }



