package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndPassword(String email,String password);
    User findByEmailAndPassword(String email,String password);
}
