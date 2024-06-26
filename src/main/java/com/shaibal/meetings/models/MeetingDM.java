package com.shaibal.meetings.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
@Data
public class MeetingDM {
    private String id;
    private String organizer;
    private String title;
    private Integer currentNumOfAttendees;
    private Set<String> attendees;
    private Set<String> pendingAttendees;
    private Integer numberOfPeopleLimit;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    private Boolean isPendingRequired;
    private Integer minAge;
    private Integer maxAge;
    private Location location;
    private String purpose;
    private String freeText;
}
