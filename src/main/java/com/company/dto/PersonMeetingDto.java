package com.company.dto;

public class PersonMeetingDto {
    private Integer id_person;
    private String nick;
    private String name;
    private String surname;
    private String email;
    private String user_type;

    public PersonMeetingDto() {
    }

    /**
     * PersonMeetingDto
     *
     * Dto used to hold data of users present in a meeting
     *
     * @param id_person
     * @param nick
     * @param name
     * @param surname
     * @param email
     * @param user_type
     */
    public PersonMeetingDto(Integer id_person, String nick, String name, String surname, String email, String user_type) {
        this.id_person = id_person;
        this.nick = nick;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.user_type = user_type;
    }

    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
