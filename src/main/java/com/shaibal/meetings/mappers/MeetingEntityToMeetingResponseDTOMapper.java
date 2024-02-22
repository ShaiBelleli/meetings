package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.models.MeetingResponseDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MeetingEntityToMeetingResponseDTOMapper implements Function<Meeting, MeetingResponseDTO> {

    @Override
    public MeetingResponseDTO apply(Meeting entity) {
        return MeetingResponseDTO.builder()
                .id(entity.getId())
                .organizer(entity.getOrganizer())
                .title(entity.getTitle())
                .numberOfPeopleLimit(entity.getNumberOfPeopleLimit())
                .startTime(entity.getStartTime())
                .minAge(entity.getMinAge())
                .maxAge(entity.getMaxAge())
                .location(entity.getLocation())
                .purpose(entity.getPurpose())
                .freeText(entity.getFreeText())
                .build();
    }
}
