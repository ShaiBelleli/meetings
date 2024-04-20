package com.shaibal.meetings.models.input;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateMeetingAttendanceRequestInputDM {
    private String meetingId;
    private String userDisplayName;
    private Integer userAge;
    private String instagramUrl;
}
