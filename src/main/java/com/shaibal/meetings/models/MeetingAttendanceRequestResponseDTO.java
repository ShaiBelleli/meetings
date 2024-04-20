package com.shaibal.meetings.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingAttendanceRequestResponseDTO {
    private String id;
    private String meetingId;
    private String userDisplayName;
    private Integer userAge;
    private String instagramUrl;
}
