package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingAttendanceRequestResponseDTO;
import com.shaibal.meetings.models.entities.MeetingAttendanceRequest;
import org.springframework.stereotype.Component;

@Component
public class MeetingAttendanceRequestEntityToMeetingAttendanceRequestResponseDTOMapper implements IMapper<MeetingAttendanceRequestResponseDTO, MeetingAttendanceRequest> {
    @Override
    public MeetingAttendanceRequestResponseDTO map(MeetingAttendanceRequest src) {
        return MeetingAttendanceRequestResponseDTO.builder()
                .id(src.getId())
                .meetingId(src.getMeetingId())
                .status(src.getStatus())
                .gender(src.getGender())
                .instagramUrl(src.getInstagramUrl())
                .userAge(src.getUserAge())
                .userDisplayName(src.getUserDisplayName())
                .status(src.getStatus())
                .build();
    }
}
