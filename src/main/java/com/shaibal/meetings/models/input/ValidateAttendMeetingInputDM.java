package com.shaibal.meetings.models.input;

import com.shaibal.meetings.security.users.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

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
    private String userDisplayName;
    private Set<String> attendees;
    private Set<String> pendingAttendees;
}
