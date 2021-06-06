package com.company.dto;

public class UserDto {
    private Integer id_person;
    private String nick;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserDto(){
    }

    public UserDto(Integer id_person, String nick, String name, String surname, String email, String password) {
        this.id_person = id_person;
        this.nick = nick;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
