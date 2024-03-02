package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.mappers.MeetingRequestDTOToMeetingDTOMapper;
import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.security.repository.UserRepository;
import com.shaibal.meetings.security.services.JwtService;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrichMeetingWithUserDetailsStep implements IStep {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final MeetingRequestDTOToMeetingDTOMapper meetingRequestDTOToMeetingDTOMapper;

    @Override
    public void execute(Context context) throws Exception {
        String jwtToken = (String) context.getValue(ContextConstants.JWT_TOKEN);
        MeetingRequestDTO meetingRequestDTO = (MeetingRequestDTO) context.getValue(ContextConstants.MEETING_REQUEST_DTO);

        String userEmail = jwtService.extractUserEmail(jwtToken);

        User user = userRepository.findByEmail(userEmail);

        MeetingDTO meetingDTO = meetingRequestDTOToMeetingDTOMapper.map(meetingRequestDTO);

        meetingDTO.setOrganizer(user.getDisplayName());

        context.setValue(ContextConstants.MEETING_DTO_AFTER_USER_DETAILS_ENRICHMENT, meetingDTO);
    }
}
