package com.ingenia.projectbank.model.modelTemp;

import io.swagger.annotations.ApiModelProperty;

public class AuthenticationRequest {

    @ApiModelProperty("email authentication Request")
    private String email;

    @ApiModelProperty(" email  authentication Request")
    private String password;


    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
