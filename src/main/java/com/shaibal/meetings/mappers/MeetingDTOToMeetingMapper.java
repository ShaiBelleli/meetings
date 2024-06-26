package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.entities.Meeting;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class MeetingDTOToMeetingMapper implements IMapper<Meeting, MeetingDTO> {
    @Override
    public Meeting map(MeetingDTO meetingDTO) {
        return Meeting.builder()
                .organizer(meetingDTO.getOrganizer())
                .title(meetingDTO.getTitle())
                .numberOfPeopleLimit(meetingDTO.getNumberOfPeopleLimit())
                .startTime(meetingDTO.getStartTime())
                .endTime(meetingDTO.getEndTime())
                .isAllowingAttendanceAfterStartTime(meetingDTO.getIsAllowingAttendanceAfterStartTime())
                .minAge(meetingDTO.getMinAge())
                .maxAge(meetingDTO.getMaxAge())
                .location(meetingDTO.getLocation())
                .purpose(meetingDTO.getPurpose())
                .freeText(meetingDTO.getFreeText())
                .isPendingRequired(meetingDTO.getIsPendingRequired())
                .currentNumOfAttendees(1)
                .attendees(new HashSet<>() {{ add(meetingDTO.getOrganizer()); }})
                .pendingAttendees(new HashSet<>())
                .build();
    }
}
