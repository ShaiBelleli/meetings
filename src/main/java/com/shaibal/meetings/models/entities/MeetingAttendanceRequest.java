package com.shaibal.meetings.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingAttendanceRequest {
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.shaibal.meetings.util.id_generators.MeetingAttendanceRequestIdGenerator")
    private String id;
    private String meetingId;
    private String userDisplayName;
    private Integer userAge;
    //private LocalDateTime createdAt;
    private String instagramUrl;
    // private String gender;
}
