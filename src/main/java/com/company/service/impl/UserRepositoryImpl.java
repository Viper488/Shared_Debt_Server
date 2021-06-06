package com.company.service.impl;

import com.company.dto.*;
import com.company.service.UserRepository;
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
        Connection c = null;
        Statement stmt  = null;
        List<UserDto> users  = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://195.150.230.210:5434/2020_hamernik_artur",
                            "2020_hamernik_artur", "31996");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
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
        System.out.println("Users downloaded successfully");
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
        Connection c = null;
        Statement stmt  = null;
        List<MeetingDto> meetingDtos  = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://195.150.230.210:5434/2020_hamernik_artur",
                            "2020_hamernik_artur", "31996");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
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
        System.out.println("Meetings downloaded successfully");
    }
}
