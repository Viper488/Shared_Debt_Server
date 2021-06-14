package com.company.dto;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto() {
    }

    /**
     * LoginDto
     *
     * Dto used to send login data via http request
     *
     * @param email
     * @param password
     */
    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
