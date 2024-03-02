package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.constants.ErrorMessagesConstants;
import com.shaibal.meetings.error_handling.MaximumNumberOfPeopleReachedException;
import com.shaibal.meetings.error_handling.MeetingDateExpiredException;
import com.shaibal.meetings.error_handling.MeetingStartDatePassedException;
import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.ValidateAttendMeetingInputDM;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Component
public class ValidateAttendMeetingService {

    public void validate(ValidateAttendMeetingInputDM validateAttendMeetingInputDM) throws NoSuchElementException {
        LocalDateTime meetingStartTime = validateAttendMeetingInputDM.getMeetingStartTime();
        LocalDateTime meetingEndTime = validateAttendMeetingInputDM.getMeetingEndTime();
        Boolean isAllowingAttendanceAfterStartTime = validateAttendMeetingInputDM.getIsAllowingAttendanceAfterStartTime();
        Integer numberOfPeopleLimit = validateAttendMeetingInputDM.getNumberOfPeopleLimit();
        Integer currentNumOfAttendees = validateAttendMeetingInputDM.getCurrentNumOfAttendees();
        Integer minAge = validateAttendMeetingInputDM.getMinAge();
        Integer maxAge = validateAttendMeetingInputDM.getMaxAge();
        Integer userAge = validateAttendMeetingInputDM.getUserAge();

        validateMeetingDateNotExpired(meetingEndTime);
        validateIsAllowingAttendanceAfterStartTime(meetingStartTime, isAllowingAttendanceAfterStartTime);
        validateNumberOfPeople(currentNumOfAttendees, numberOfPeopleLimit);
        validateAge(userAge, minAge, maxAge);
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

    private void validateAge(Integer age, Integer minAge, Integer maxAge) {

    }
}
