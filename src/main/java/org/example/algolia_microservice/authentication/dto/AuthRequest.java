package org.example.algolia_microservice.authentication.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public AuthRequest(@NotBlank String email,@NotBlank String password) {
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
