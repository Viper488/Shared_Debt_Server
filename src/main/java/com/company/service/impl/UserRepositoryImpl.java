package com.company.service.impl;

import com.company.dto.*;
import com.company.rest.Controller;
import com.company.service.ConnectDB;
import com.company.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private UserListDto userListDto;
    private MeetingListDto meetingListDto;
    private static final Logger LOGGER  = LoggerFactory.getLogger(UserRepositoryImpl.class);

    public UserRepositoryImpl() {
        initUsers();
        initMeetings();
    }

    @Override
    public UserListDto getUsers() {
        return userListDto;
    }

    @Override
    public MeetingListDto getMeetings() {
        return meetingListDto;
    }

    @Override
    public void initUsers(){
        List<UserDto> users  = new ArrayList<>();
        try {
            Connection c = ConnectDB.connectToDB();
            LOGGER.info("Opened database successfully");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM debt.person");
            while ( rs.next() ) {
                Integer sqlId = rs.getInt("id_person");
                String sqlNick = rs.getString("nick");
                String sqlName = rs.getString("name");
                String sqlSurname = rs.getString("surname");
                String sqlEmail = rs.getString("email");
                String sqlPassword = rs.getString("password");
                users.add(new UserDto(sqlId,sqlNick,sqlName,sqlSurname,sqlEmail,sqlPassword));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        userListDto = new UserListDto(users);
        LOGGER.info("Users downloaded successfully");
    }
    @Override
    public UserDto findUser(String email, String password){
        for(UserDto loginUser :userListDto.getUsers()) {
            if(loginUser.getEmail().equals(email) && loginUser.getPassword().equals(password)){
                return loginUser;
            }
        }
        return null;
    }
    @Override
    public void initMeetings(){
        List<MeetingDto> meetingDtos  = new ArrayList<>();
        try {
            Connection c = ConnectDB.connectToDB();
            LOGGER.info("Opened database successfully");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM debt.meeting");
            while ( rs.next() ) {
                Integer sqlId = rs.getInt("id_meeting");
                String sqlName = rs.getString("name");
                String sqlCode = rs.getString("code");
                String sqlPassword = rs.getString("password");
                meetingDtos.add(new MeetingDto(sqlId,sqlName,sqlCode,sqlPassword));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        meetingListDto = new MeetingListDto(meetingDtos);
        LOGGER.info("Meetings downloaded successfully");
    }
}
