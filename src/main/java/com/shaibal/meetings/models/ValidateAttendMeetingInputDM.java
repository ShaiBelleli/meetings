package com.shaibal.meetings.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ValidateAttendMeetingInputDM {
    private LocalDateTime meetingStartTime;
    private LocalDateTime meetingEndTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    private Integer numberOfPeopleLimit;
    private Integer currentNumOfAttendees;
    private Integer minAge;
    private Integer maxAge;
    private Integer userAge;
}
