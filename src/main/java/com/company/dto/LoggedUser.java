package com.company.dto;

public class LoggedUser {
    private Integer user_id;
    private String nick;
    private String name;
    private String surname;
    public LoggedUser() {
    }

    public LoggedUser(Integer user_id, String nick, String name, String surname) {
        this.user_id = user_id;
        this.nick = nick;
        this.name = name;
        this.surname = surname;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNick() {
        return nick;
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
}
