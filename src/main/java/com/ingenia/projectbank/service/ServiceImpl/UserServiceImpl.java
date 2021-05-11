package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.model.User;
import com.ingenia.projectbank.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public Optional<User> findOneUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteOneUserById(Long id) {

    }

    @Override
    public void deleteAllUsers() {

    }
}
