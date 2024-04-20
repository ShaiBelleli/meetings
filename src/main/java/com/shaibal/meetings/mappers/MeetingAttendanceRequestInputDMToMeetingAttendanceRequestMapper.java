package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.entities.MeetingAttendanceRequest;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import org.springframework.stereotype.Component;

@Component
public class MeetingAttendanceRequestInputDMToMeetingAttendanceRequestMapper implements IMapper<MeetingAttendanceRequest, CreateMeetingAttendanceRequestInputDM> {
    @Override
    public MeetingAttendanceRequest map(CreateMeetingAttendanceRequestInputDM src) {
        return MeetingAttendanceRequest.builder()
                .id(src.getMeetingId())
                .instagramUrl(src.getInstagramUrl())
                .userDisplayName(src.getUserDisplayName())
                .userAge(src.getUserAge())
                .build();
    }
}
