package com.shaibal.meetings.services;

import com.shaibal.meetings.models.input.AttendMeetingServiceInputDM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AttendMeetingService {
    public Set<String> attendMeeting(AttendMeetingServiceInputDM attendMeetingServiceInputDM) {
        String userDisplayName = attendMeetingServiceInputDM.getDisplayName();
        Set<String> attendeesListToInsertAttendee;

        if (Boolean.TRUE.equals(attendMeetingServiceInputDM.getIsPendingRequired())) {
            attendeesListToInsertAttendee = attendMeetingServiceInputDM.getPendingAttendees();

        }
        else {
            attendeesListToInsertAttendee = attendMeetingServiceInputDM.getAttendees();
        }

        attendeesListToInsertAttendee.add(userDisplayName);

        return attendeesListToInsertAttendee;
    }
}
