package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.entities.Meeting;
import org.springframework.stereotype.Component;

@Component
public class MeetingResponseDTOToMeetingDMMapper implements IMapper<MeetingDM, MeetingResponseDTO> {

    @Override
    public MeetingDM map(MeetingResponseDTO meetingResponseDTO) {
        MeetingDM result = new MeetingDM();

        result.setId(meetingResponseDTO.getId());
        result.setOrganizer(meetingResponseDTO.getOrganizer());
        result.setTitle(meetingResponseDTO.getTitle());
        result.setNumberOfPeopleLimit(meetingResponseDTO.getNumberOfPeopleLimit());
        result.setStartTime(meetingResponseDTO.getStartTime());
        result.setEndTime(meetingResponseDTO.getEndTime());
        result.setIsAllowingAttendanceAfterStartTime(meetingResponseDTO.getIsAllowingAttendanceAfterStartTime());
        result.setCurrentNumOfAttendees(meetingResponseDTO.getCurrentNumOfAttendees());
        result.setMinAge(meetingResponseDTO.getMinAge());
        result.setMaxAge(meetingResponseDTO.getMaxAge());
        result.setLocation(meetingResponseDTO.getLocation());
        result.setPurpose(meetingResponseDTO.getPurpose());
        result.setFreeText(meetingResponseDTO.getFreeText());
        result.setIsPendingRequired(meetingResponseDTO.getIsPendingRequired());
        result.setAttendees(meetingResponseDTO.getAttendees());
        result.setPendingAttendees(meetingResponseDTO.getPendingAttendees());

        return result;
    }

}
