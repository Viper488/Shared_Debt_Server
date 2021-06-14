package com.company.dto;

import java.util.List;

public class UserListDto {
    private List<UserDto> users;

    public UserListDto() {
    }

    /**
     * Dto holding list of users
     * @param users
     */
    public UserListDto(List<UserDto> users) {
        this.users = users;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
