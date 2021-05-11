package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
