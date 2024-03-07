package com.shaibal.meetings.models.input;

import com.shaibal.meetings.security.users.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Data
public class AttendMeetingServiceInputDM {
    private String attendeeFirstName;
    private String attendeeLastName;
    private String instagramUrl;
    private String displayName;
    private Integer age;
    private Set<String> pendingAttendees;
    private Set<String> attendees;
    private Boolean isPendingRequired;
}
