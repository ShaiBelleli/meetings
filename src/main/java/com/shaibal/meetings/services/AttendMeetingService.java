package com.shaibal.meetings.services;

import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.input.AttendMeetingServiceInputDM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AttendMeetingService {
    public void attendMeeting(AttendMeetingServiceInputDM attendMeetingServiceInputDM, MeetingResponseDTO meetingDTO) {
        String userDisplayName = attendMeetingServiceInputDM.getDisplayName();

        meetingDTO.getAttendees().add(userDisplayName);
        meetingDTO.setCurrentNumOfAttendees(meetingDTO.getCurrentNumOfAttendees() + 1);
    }
}
