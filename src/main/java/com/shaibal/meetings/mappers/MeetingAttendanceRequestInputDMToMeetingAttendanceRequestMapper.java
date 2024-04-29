package com.shaibal.meetings.mappers;

import com.shaibal.meetings.constants.BusinessConstants;
import com.shaibal.meetings.models.entities.MeetingAttendanceRequest;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import org.springframework.stereotype.Component;

@Component
public class MeetingAttendanceRequestInputDMToMeetingAttendanceRequestMapper implements IMapper<MeetingAttendanceRequest, CreateMeetingAttendanceRequestInputDM> {
    @Override
    public MeetingAttendanceRequest map(CreateMeetingAttendanceRequestInputDM src) {
        return MeetingAttendanceRequest.builder()
                .meetingId(src.getMeetingId())
                .instagramUrl(src.getInstagramUrl())
                .gender(src.getGender())
                .userDisplayName(src.getUserDisplayName())
                .userAge(src.getUserAge())
                .status(BusinessConstants.STATUS_SUBMITTED)
                .build();
    }
}
