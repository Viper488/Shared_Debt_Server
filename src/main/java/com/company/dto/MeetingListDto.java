package com.company.dto;

import java.util.List;

public class MeetingListDto {
    private List<MeetingDto> meetingDtoList;

    public MeetingListDto() {
    }

    /**
     * MeetingListDto
     *
     * Dto used to send list of meetings via http request to user
     *
     * @param meetingDtoList
     */
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
