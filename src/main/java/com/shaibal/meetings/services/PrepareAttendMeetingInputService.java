package com.shaibal.meetings.services;

import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.input.AttendMeetingServiceInputDM;
import com.shaibal.meetings.security.repository.UserRepository;
import com.shaibal.meetings.security.services.JwtService;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrepareAttendMeetingInputService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final GetMeetingService getMeetingService;
    public AttendMeetingServiceInputDM prepareInput(String meetingId, String jwtToken) {
        MeetingResponseDTO meetingResponseDTO = getMeetingService.getMeeting(meetingId);
        String userEmail = jwtService.extractUserEmail(jwtToken);
        User user = userRepository.findByEmail(userEmail);

        return prepareAttendMeetingInputDMFromUserAndMeeting(user, meetingResponseDTO);
    }

    private AttendMeetingServiceInputDM prepareAttendMeetingInputDMFromUserAndMeeting(User user, MeetingResponseDTO meetingResponseDTO) {
        AttendMeetingServiceInputDM attendMeetingServiceInputDM = new AttendMeetingServiceInputDM();

        attendMeetingServiceInputDM.setAttendeeFirstName(user.getFirstName());
        attendMeetingServiceInputDM.setAttendeeLastName(user.getLastName());
        attendMeetingServiceInputDM.setInstagramUrl(user.getInstagramUrl());
        attendMeetingServiceInputDM.setDisplayName(user.getDisplayName());
        attendMeetingServiceInputDM.setAge(user.getAge());

        attendMeetingServiceInputDM.setAttendees(meetingResponseDTO.getAttendees());
        attendMeetingServiceInputDM.setPendingAttendees(meetingResponseDTO.getPendingAttendees());
        attendMeetingServiceInputDM.setIsPendingRequired(meetingResponseDTO.getIsPendingRequired());

        return attendMeetingServiceInputDM;
    }
}
