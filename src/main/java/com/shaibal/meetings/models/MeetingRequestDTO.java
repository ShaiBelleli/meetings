package com.shaibal.meetings.models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRequestDTO {
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
    private Boolean isPendingRequired;
    // We will be able to filter by purpose
    private String purpose;
    private String freeText;
}
