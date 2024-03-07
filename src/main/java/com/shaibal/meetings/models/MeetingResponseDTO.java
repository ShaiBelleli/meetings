package com.shaibal.meetings.models;

import com.shaibal.meetings.security.users.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingResponseDTO {
    private String id;
    private String organizer;
    private String title;
    private Integer numberOfPeopleLimit;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    private Integer currentNumOfAttendees;
    private Set<String> attendees;
    private Set<String> pendingAttendees;
    private Boolean isPendingRequired;
    private Integer minAge;
    private Integer maxAge;
    private Location location;
    private String purpose;
    private String freeText;
}
