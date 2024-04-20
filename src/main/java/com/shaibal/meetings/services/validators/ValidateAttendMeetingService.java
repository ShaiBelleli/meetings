package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.constants.ErrorMessagesConstants;
import com.shaibal.meetings.error_handling.MaximumNumberOfPeopleReachedException;
import com.shaibal.meetings.error_handling.MeetingDateExpiredException;
import com.shaibal.meetings.error_handling.MeetingStartDatePassedException;
import com.shaibal.meetings.models.input.ValidateAttendMeetingInputDM;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ValidateAttendMeetingService {

    public void validate(ValidateAttendMeetingInputDM validateAttendMeetingInputDM) throws NoSuchElementException, BadRequestException {
        LocalDateTime meetingStartTime = validateAttendMeetingInputDM.getMeetingStartTime();
        LocalDateTime meetingEndTime = validateAttendMeetingInputDM.getMeetingEndTime();
        Boolean isAllowingAttendanceAfterStartTime = validateAttendMeetingInputDM.getIsAllowingAttendanceAfterStartTime();
        Integer numberOfPeopleLimit = validateAttendMeetingInputDM.getNumberOfPeopleLimit();
        Integer currentNumOfAttendees = validateAttendMeetingInputDM.getCurrentNumOfAttendees();
        Integer minAge = validateAttendMeetingInputDM.getMinAge();
        Integer maxAge = validateAttendMeetingInputDM.getMaxAge();
        Integer userAge = validateAttendMeetingInputDM.getUserAge();
        Set<String> attendees = validateAttendMeetingInputDM.getAttendees();
        //Set<String> pendingAttendees = validateAttendMeetingInputDM.getPendingAttendees();
        String userDisplayName = validateAttendMeetingInputDM.getUserDisplayName();

        validateMeetingDateNotExpired(meetingEndTime);
        validateIsAllowingAttendanceAfterStartTime(meetingStartTime, isAllowingAttendanceAfterStartTime);
        validateNumberOfPeople(currentNumOfAttendees, numberOfPeopleLimit);
        validateAge(userAge, minAge, maxAge);
        validateNotAlreadyInListOfAttendees(attendees, userDisplayName);
        //validateNotAlreadyInListOfPendingAttendees(pendingAttendees, userDisplayName);
    }

//    private void validateNotAlreadyInListOfPendingAttendees(Set<String> pendingAttendees, String userDisplayName) throws BadRequestException {
//        validateUserIsNotAlreadyPendingAttendee(pendingAttendees, userDisplayName);
//    }

    private void validateNotAlreadyInListOfAttendees(Set<String> attendees, String userDisplayName) throws BadRequestException {
        validateUserIsNotAlreadyAttendee(attendees, userDisplayName);
    }

    private void validateUserIsNotAlreadyAttendee(Set<String> attendees, String userDisplayName) throws BadRequestException {
        if (attendees.contains(userDisplayName)) {
            throw new BadRequestException("You are already attending this meeting.");
        }
    }

//    private void validateUserIsNotAlreadyPendingAttendee(Set<String> pendingAttendees, String userDisplayName) throws BadRequestException {
//        if (pendingAttendees.contains(userDisplayName)) {
//            throw new BadRequestException("You have already asked to attend this meeting.");
//        }
//    }

    private void validateMeetingDateNotExpired(LocalDateTime meetingEndTime) throws MeetingDateExpiredException {
        if (meetingEndTime == null) {
            return;
        }

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
        if (numberOfPeopleLimit == null) {
            return;
        }

        if (currentNumOfAttendees >= numberOfPeopleLimit) {
            throw new MaximumNumberOfPeopleReachedException(ErrorMessagesConstants.MAXIMUM_NUMBER_OF_PEOPLE_REACHED_EXCEPTION_MSG);
        }
    }

    private void validateAge(Integer age, Integer minAge, Integer maxAge) throws BadRequestException {
        if (minAge != null && age < minAge) {
            throw new BadRequestException("You are too young for this meeting.");
        }

        if (maxAge != null && age > maxAge) {
            throw new BadRequestException("Your age is past the age limit for this meeting.");
        }
    }
}
