package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.entities.Meeting;
import org.springframework.stereotype.Component;

@Component
public class MeetingDMToMeetingEntityMapper implements IMapper <Meeting, MeetingDM> {
    @Override
    public Meeting map(MeetingDM meetingDM) {
        Meeting result = new Meeting();

        result.setId(meetingDM.getId());
        result.setOrganizer(meetingDM.getOrganizer());
        result.setTitle(meetingDM.getTitle());
        result.setNumberOfPeopleLimit(meetingDM.getNumberOfPeopleLimit());
        result.setStartTime(meetingDM.getStartTime());
        result.setEndTime(meetingDM.getEndTime());
        result.setIsAllowingAttendanceAfterStartTime(meetingDM.getIsAllowingAttendanceAfterStartTime());
        result.setCurrentNumOfAttendees(meetingDM.getCurrentNumOfAttendees());
        result.setMinAge(meetingDM.getMinAge());
        result.setMaxAge(meetingDM.getMaxAge());
        result.setLocation(meetingDM.getLocation());
        result.setPurpose(meetingDM.getPurpose());
        result.setFreeText(meetingDM.getFreeText());
        result.setIsPendingRequired(meetingDM.getIsPendingRequired());
        result.setAttendees(meetingDM.getAttendees());
        result.setPendingAttendees(meetingDM.getPendingAttendees());

        return result;
    }
}



