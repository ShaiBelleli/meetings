package com.shaibal.meetings.models.entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.shaibal.meetings.models.Location;
import com.shaibal.meetings.security.users.User;
import jakarta.persistence.*;
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
    private String organizer;
    @NonNull
    private String title;
    private Integer numberOfPeopleLimit;
    @NonNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAllowingAttendanceAfterStartTime;
    private Integer currentNumOfAttendees;
    @ElementCollection
    @CollectionTable(name = "meetings_users", joinColumns = @JoinColumn(name = "meeting_id"))
    @Column(name = "attendee_display_name")
    private Set<String> attendees;
    @ElementCollection
    @CollectionTable(name = "meetings_users", joinColumns = @JoinColumn(name = "meeting_id"))
    @Column(name = "pending_attendee_display_name")
    private Set<String> pendingAttendees;
    private Boolean isPendingRequired;
    private Integer minAge;
    private Integer maxAge;
    @NonNull
    private Location location;
    private String purpose;
    private String freeText;
}
