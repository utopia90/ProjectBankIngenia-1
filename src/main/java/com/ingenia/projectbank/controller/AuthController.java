package com.ingenia.projectbank.controller;

import com.ingenia.projectbank.model.User;
import com.ingenia.projectbank.model.modelTemp.AuthenticationRequest;
import com.ingenia.projectbank.model.modelTemp.AuthenticationResponse;
import com.ingenia.projectbank.service.BankCardService;
import com.ingenia.projectbank.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
     UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest userRequest) {
        if (userService.existsByEmailAndPassword(userRequest.getEmail(),userRequest.getPassword())) {
            User UserEncontrado=userService.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
            //TODO pendiente de configuracion Spring Security
          /*  UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);*/
            //TODO pendiente de configuracion Spring Security
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
