package com.ingenia.projectbank.service;

import com.ingenia.projectbank.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    Optional<User> findOneUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteOneUserById(Long id);

    void deleteAllUsers();

    User findUserByEmail(String email);

    User findByEmailAndPassword(String email , String password);

    Boolean existsByEmailAndPassword(String email , String password);



}
