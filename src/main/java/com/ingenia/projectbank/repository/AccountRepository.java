package com.ingenia.projectbank.repository;

import com.ingenia.projectbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
