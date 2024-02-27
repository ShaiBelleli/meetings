package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.constants.ErrorMessagesConstants;
import com.shaibal.meetings.exceptions.MaximumNumberOfPeopleReachedException;
import com.shaibal.meetings.exceptions.MeetingDateExpiredException;
import com.shaibal.meetings.exceptions.MeetingStartDatePassedException;
import com.shaibal.meetings.models.MeetingDM;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Component
public class ValidateAttendMeetingService {

    public void validate(MeetingDM meetingDM) throws NoSuchElementException {
        String meetingId = meetingDM.getId();
        LocalDateTime meetingStartTime = meetingDM.getStartTime();
        LocalDateTime meetingEndTime = meetingDM.getEndTime();
        Boolean isAllowingAttendanceAfterStartTime = meetingDM.getIsAllowingAttendanceAfterStartTime();
        Integer numberOfPeopleLimit = meetingDM.getNumberOfPeopleLimit();
        Integer currentNumOfAttendees = meetingDM.getCurrentNumOfAttendees();
        Integer minAge = meetingDM.getMinAge();
        Integer maxAge = meetingDM.getMaxAge();
        // Integer userAge = userDetails.getAge();

        validateMeetingDateNotExpired(meetingEndTime);
        validateIsAllowingAttendanceAfterStartTime(meetingStartTime, isAllowingAttendanceAfterStartTime);
        validateNumberOfPeople(currentNumOfAttendees, numberOfPeopleLimit);
        //validateAge(/*userAge, */minAge, maxAge);
    }


    private void validateMeetingDateNotExpired(LocalDateTime meetingEndTime) throws MeetingDateExpiredException {
        if (LocalDateTime.now().isAfter(meetingEndTime)) {
            throw new MeetingDateExpiredException(ErrorMessagesConstants.MEETING_DATE_EXPIRED_EXCEPTION_MSG);
        }
    }

    private void validateIsAllowingAttendanceAfterStartTime(LocalDateTime meetingStartTime, Boolean isAllowingAttendanceAfterStartTime)
            throws MeetingStartDatePassedException {
        if (Boolean.FALSE.equals(isAllowingAttendanceAfterStartTime) && meetingStartTime.isAfter(LocalDateTime.now())) {
            throw new MeetingStartDatePassedException(ErrorMessagesConstants.MEETING_START_DATE_PASSED_EXCEPTION_MSG);
        }
    }

    private void validateNumberOfPeople(Integer currentNumOfAttendees, Integer numberOfPeopleLimit)
            throws MaximumNumberOfPeopleReachedException {
        if (currentNumOfAttendees >= numberOfPeopleLimit) {
            throw new MaximumNumberOfPeopleReachedException(ErrorMessagesConstants.MAXIMUM_NUMBER_OF_PEOPLE_REACHED_EXCEPTION_MSG);
        }
    }
}
