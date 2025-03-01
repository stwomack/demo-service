package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuthRequest {
    @Id
    @GeneratedValue
    private Long id;

    private String authType;

    private boolean authorized;

    public AuthRequest(String authType, boolean authorized) {
        this.authType = authType;
        this.authorized = authorized;
    }

    public AuthRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
