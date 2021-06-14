package com.company.dto;

import java.util.List;

public class MeetingDetailsDto {
    private Integer id_meeting;
    private String name;
    private String code;
    private String password;
    private List<PersonMeetingDto> personMeetingList;

    public MeetingDetailsDto() {
    }

    /**
     * MeetingDetailsDto
     *
     * Dto used to hold details of a meeting, mostly used to hold list of users present in the meeting
     *
     * @param id_meeting
     * @param name
     * @param code
     * @param password
     * @param personMeetingList
     */
    public MeetingDetailsDto(Integer id_meeting, String name, String code, String password, List<PersonMeetingDto> personMeetingList) {
        this.id_meeting = id_meeting;
        this.name = name;
        this.code = code;
        this.password = password;
        this.personMeetingList = personMeetingList;
    }

    public Integer getId_meeting() {
        return id_meeting;
    }

    public void setId_meeting(Integer id_meeting) {
        this.id_meeting = id_meeting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PersonMeetingDto> getPersonMeetingList() {
        return personMeetingList;
    }

    public void setPersonMeetingList(List<PersonMeetingDto> personMeetingList) {
        this.personMeetingList = personMeetingList;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
