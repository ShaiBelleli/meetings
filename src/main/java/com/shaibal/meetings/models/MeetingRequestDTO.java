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
    private String title;
    private Integer numberOfPeopleLimit;
    @NonNull
    private LocalDateTime startTime;
    private Integer minAge;
    private Integer maxAge;
    @NonNull
    private String city;
    @NonNull
    private String street;
    @NonNull
    private String streetNumber;
    private String arrivalInstructions;
    // We will be able to filter by purpose
    private String purpose;
    private String freeText;
}
