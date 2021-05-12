package com.ingenia.projectbank.service.ServiceImpl;

import com.ingenia.projectbank.dao.UserDao;
import com.ingenia.projectbank.model.User;
import com.ingenia.projectbank.repository.UserRepository;
import com.ingenia.projectbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;


    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAllUsers() {

        return repository.findAll();
    }

    @Override
    public Optional<User> findOneUserById(Long id) {
        if(id!=null)return this.repository.findById(id);
        return null;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(user.getId()!=null)repository.save(user);
        return null;
    }

    @Override
    public void deleteOneUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        repository.deleteAll();
    }

    @Override
    public User findUserByEmail(String email) {
        if (repository.existsUserByEmail(email)) {
           return repository.findUserByEmail(email);
        }
        return null;
    }
    @Override
    public User findByEmailAndPassword(String email, String password) {
        if (repository.existsByEmailAndPassword(email,password)) {
            return repository.findByEmailAndPassword(email,password);
        }
        return null;
    }

    @Override
    public Boolean existsByEmailAndPassword(String email, String password) {
        return repository.existsByEmailAndPassword(email,password);
    }
}
