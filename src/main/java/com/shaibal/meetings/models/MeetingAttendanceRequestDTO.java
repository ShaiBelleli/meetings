package com.shaibal.meetings.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingAttendanceRequestDTO {
    private String meetingId;
    private String userDisplayName;
    private Integer userAge;
    private String instagramUrl;
    private String gender;
}
