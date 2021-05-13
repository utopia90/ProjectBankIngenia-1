package com.ingenia.projectbank.model.modelTemp;

import io.swagger.annotations.ApiModelProperty;

public class AuthenticationResponse {
private String jwt;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
    @ApiModelProperty("JWT TOKEN")
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
