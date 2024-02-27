package com.shaibal.meetings.models.entities;

import java.time.LocalDateTime;

import com.shaibal.meetings.models.Location;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;


@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.shaibal.meetings.util.CustomIdGenerator")
    private String id;
    private String organizer; // Should get from User Details
    @NonNull
    private String title;
    private Integer numberOfPeopleLimit;
    @NonNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    private Integer currentNumOfAttendees;
    private Integer minAge;
    private Integer maxAge;
    @NonNull
    private Location location;
    private String purpose;
    private String freeText;
}
