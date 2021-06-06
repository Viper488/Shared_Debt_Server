package com.company.dto;

import java.util.List;

public class MeetingListDto {
    private List<MeetingDto> meetingDtoList;

    public MeetingListDto() {
    }

    public MeetingListDto(List<MeetingDto> meetingDtoList) {
        this.meetingDtoList = meetingDtoList;
    }

    public List<MeetingDto> getMeetingDtoList() {
        return meetingDtoList;
    }

    public void setMeetingDtoList(List<MeetingDto> meetingDtoList) {
        this.meetingDtoList = meetingDtoList;
    }
}
