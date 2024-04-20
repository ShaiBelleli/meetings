package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.mappers.MeetingResponseDTOToAttendMeetingValidationDMMapper;
import com.shaibal.meetings.models.input.ValidateAttendMeetingInputDM;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.security.repository.UserRepository;
import com.shaibal.meetings.security.services.JwtService;
import com.shaibal.meetings.security.users.User;
import com.shaibal.meetings.services.GetMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrepareValidateAttendMeetingInputStep implements IStep {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final MeetingResponseDTOToAttendMeetingValidationDMMapper meetingResponseDTOToAttendMeetingValidationDMMapper;
    private final GetMeetingService getMeetingService;

    @Override
    public void execute(Context context) throws Exception {
        String jwtToken = (String) context.getValue(ContextConstants.JWT_TOKEN);
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);

        MeetingResponseDTO meetingResponseDTO = getMeetingService.getMeeting(meetingId);
        ValidateAttendMeetingInputDM validateAttendMeetingInputDM = meetingResponseDTOToAttendMeetingValidationDMMapper.map(meetingResponseDTO);
        String userEmail = jwtService.extractUserEmail(jwtToken);
        User user = userRepository.findByEmail(userEmail);

        //This should not be here, should be in a different UserDetails..
        validateAttendMeetingInputDM.setUserAge(user.getAge());
        validateAttendMeetingInputDM.setUserDisplayName(user.getDisplayName());

        context.setValue(ContextConstants.VALIDATE_ATTEND_MEETING_INPUT_DM, validateAttendMeetingInputDM);
        context.setValue(ContextConstants.MEETING_DTO, meetingResponseDTO);
        context.setValue(ContextConstants.USER_DETAILS, user);
    }
}
