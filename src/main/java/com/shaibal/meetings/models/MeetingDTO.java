package com.shaibal.meetings.models;

import lombok.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDTO {
    private String organizer;
    @NonNull
    private String title;
    private Integer numberOfPeopleLimit;
    private Integer currentNumOfAttendees;
    private Set<String> attendees;
    private Set<String> pendingAttendees;
    @NonNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    private Integer minAge;
    private Integer maxAge;
    @NonNull
    private Location location;
    private String purpose;
    private String freeText;
}
