package com.georgidinov.myapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class AuthenticationRequest {

    //== fields ==
    private String username;
    private String password;

    //== constructors ==
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    //== public methods ==
    public String extractAsJsonString() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    //== getters ==
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //== setters ==
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //== equals and hashcode
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        AuthenticationRequest anotherRequest = (AuthenticationRequest) object;

        if (!Objects.equals(username, anotherRequest.username)) {
            return false;
        }
        return Objects.equals(password, anotherRequest.password);
    }

    @Override
    public int hashCode() {
        int usernameHash = this.username != null ? this.username.hashCode() : 0;
        int passwordHash = this.password != null ? this.password.hashCode() : 0;
        int hashSum = usernameHash + passwordHash;
        return hashSum + 17;
    }

    //== to string ==
    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                " username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}