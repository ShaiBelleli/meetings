package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class MeetingRequestDTOToMeetingDTOMapper implements IMapper<MeetingDTO, MeetingRequestDTO> {

    @Override
    public MeetingDTO map(MeetingRequestDTO meetingRequestDTO) {

        // Map MeetingRequestDTO to MeetingDTO
        return MeetingDTO.builder()
                .organizer(meetingRequestDTO.getOrganizer())
                .title(meetingRequestDTO.getTitle())
                .numberOfPeopleLimit(meetingRequestDTO.getNumberOfPeopleLimit())
                .startTime(meetingRequestDTO.getStartTime())
                .endTime(meetingRequestDTO.getEndTime())
                .isAllowingAttendanceAfterStartTime(meetingRequestDTO.getIsAllowingAttendanceAfterStartTime())
                .minAge(meetingRequestDTO.getMinAge())
                .maxAge(meetingRequestDTO.getMaxAge())
                .location(meetingRequestDTO.getLocation())
                .purpose(meetingRequestDTO.getPurpose())
                .freeText(meetingRequestDTO.getFreeText())
                .build();
    }
}
