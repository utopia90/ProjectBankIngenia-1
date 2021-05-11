package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);
    Boolean existsUserByEmail(String email);
//TODO Falta el exist by user y password
//TODO Falta el find  by user y password
}
