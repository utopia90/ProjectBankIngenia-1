package com.ingenia.projectbank.controller;

import com.ingenia.projectbank.model.User;
import com.ingenia.projectbank.model.modelTemp.AuthenticationRequest;
import com.ingenia.projectbank.model.modelTemp.AuthenticationResponse;
import com.ingenia.projectbank.security.JWTUtil;
import com.ingenia.projectbank.service.ServiceImpl.UserDetailsServiceImpl;
import com.ingenia.projectbank.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;
    private final JWTUtil jwtUtil;

    public AuthController(UserService userService, UserDetailsServiceImpl userDetailsService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest userRequest) {
        if (userService.existsByEmailAndPassword(userRequest.getEmail(),userRequest.getPassword())) {
            User UserEncontrado=userService.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
            UserDetails userDetails = userDetailsService.loadUserByUsername(UserEncontrado.getEmail());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/registro")
    public ResponseEntity<User> registro(@RequestBody User user) {
        if (user==null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            User userCreado=userService.createUser(user);
            if(userCreado==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //envioEmailService.sendEmail(user.getEmail(),"Registro realizado correctamente  ","Registro correcto,  Logueate Con tus Credenciales para Iniciar Sesión");
            return ResponseEntity.ok().body(userCreado);
        }
    }
}
