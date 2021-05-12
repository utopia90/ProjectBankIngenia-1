package com.ingenia.projectbank.dao;

import com.ingenia.projectbank.model.Movement;

import java.util.Date;
import java.util.List;

public interface MovementDao {
    List<Movement> findMovementsInterval(Date firstDay, Date lastDay);

}
