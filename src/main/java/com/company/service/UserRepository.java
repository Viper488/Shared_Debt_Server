package com.company.service;

import com.company.dto.MeetingListDto;
import com.company.dto.UserDto;
import com.company.dto.UserListDto;

/**
 * UserRepository interface
 */
public interface UserRepository {
    UserListDto getUsers();
    MeetingListDto getMeetings();
    void initUsers();
    void initMeetings();
    UserDto findUser(String email, String password);

}
