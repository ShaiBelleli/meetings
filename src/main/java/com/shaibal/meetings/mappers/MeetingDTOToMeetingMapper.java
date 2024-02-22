package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.models.MeetingRequestDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MeetingDTOToMeetingMapper implements Function<MeetingDTO, Meeting> {
    @Override
    public Meeting apply(MeetingDTO meetingDTO) {
        return Meeting.builder()
                .organizer(meetingDTO.getOrganizer())
                .title(meetingDTO.getTitle())
                .numberOfPeopleLimit(meetingDTO.getNumberOfPeopleLimit())
                .startTime(meetingDTO.getStartTime())
                .minAge(meetingDTO.getMinAge())
                .maxAge(meetingDTO.getMaxAge())
                .location(meetingDTO.getLocation())
                .purpose(meetingDTO.getPurpose())
                .freeText(meetingDTO.getFreeText())
                .numOfAttendees(1)
                .build();
    }
}
