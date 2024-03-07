package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.models.MeetingResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MeetingEntityToMeetingResponseDTOMapper implements IMapper<MeetingResponseDTO, Meeting> {

    @Override
    public MeetingResponseDTO map(Meeting entity) {
        return MeetingResponseDTO.builder()
                .id(entity.getId())
                .organizer(entity.getOrganizer())
                .title(entity.getTitle())
                .numberOfPeopleLimit(entity.getNumberOfPeopleLimit())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .isAllowingAttendanceAfterStartTime(entity.getIsAllowingAttendanceAfterStartTime())
                .minAge(entity.getMinAge())
                .maxAge(entity.getMaxAge())
                .location(entity.getLocation())
                .purpose(entity.getPurpose())
                .freeText(entity.getFreeText())
                .attendees(entity.getAttendees())
                .pendingAttendees(entity.getPendingAttendees())
                .isPendingRequired(entity.getIsPendingRequired())
                .build();
    }
}
