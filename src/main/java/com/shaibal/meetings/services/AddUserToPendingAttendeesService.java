package com.shaibal.meetings.services;

import com.shaibal.meetings.models.MeetingDM;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddUserToPendingAttendeesService {

    public void addUserToPendingAttendees(String userDisplayName, MeetingDM meetingDM) {
        meetingDM.getPendingAttendees().add(userDisplayName);
    }
}
