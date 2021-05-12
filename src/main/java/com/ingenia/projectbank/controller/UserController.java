package com.ingenia.projectbank.controller;

import com.ingenia.projectbank.model.Account;
import com.ingenia.projectbank.model.BankCard;
import com.ingenia.projectbank.model.User;
import com.ingenia.projectbank.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ApiOperation(value = "encuentra todos los usuarios ")
    public List<User> findAllUsers() {
        log.debug("Rest request all users");
        return userService.findAllUsers();
    }

    /**
     * method return One account for ID
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @ApiOperation(value = "encuentra un usuario por su id")
    public ResponseEntity<User> findOneUser(@ApiParam("Clave primaria del usuario") @PathVariable Long id) {
        log.debug("Rest request a account with id: "+id);
        Optional<User> userOpt = userService.findOneUserById(id);
        if (userOpt.isPresent())
            return ResponseEntity.ok().body(userOpt.get());

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
