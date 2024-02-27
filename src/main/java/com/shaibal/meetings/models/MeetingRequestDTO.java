package com.shaibal.meetings.models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRequestDTO {
    // Getting from UserDetails
    private String organizer;
    @NonNull
    private String title;
    private Integer numberOfPeopleLimit;
    @NonNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    @NonNull
    private Location location;
    private Integer minAge;
    private Integer maxAge;
    private String arrivalInstructions;
    // We will be able to filter by purpose
    private String purpose;
    private String freeText;
}
