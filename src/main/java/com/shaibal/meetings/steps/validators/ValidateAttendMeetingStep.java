package com.shaibal.meetings.steps.validators;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.mappers.MeetingResponseDTOToMeetingDMMapper;
import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.ValidateAttendMeetingInputDM;
import com.shaibal.meetings.security.models.ValidateRegisterInputDM;
import com.shaibal.meetings.security.repository.UserRepository;
import com.shaibal.meetings.security.services.JwtService;
import com.shaibal.meetings.security.users.User;
import com.shaibal.meetings.services.GetMeetingService;
import com.shaibal.meetings.services.validators.ValidateAttendMeetingService;
import com.shaibal.meetings.steps.IStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateAttendMeetingStep implements IStep {

    private final GetMeetingService getMeetingService;
    private final ValidateAttendMeetingService validateAttendMeetingService;
    private final MeetingResponseDTOToMeetingDMMapper meetingResponseDTOToMeetingDMMapper;

    @Override
    public void execute(Context context) throws Exception {
        ValidateAttendMeetingInputDM validateAttendMeetingInputDM = (ValidateAttendMeetingInputDM) context.getValue(ContextConstants.VALIDATE_ATTEND_MEETING_INPUT_DM);

        validateAttendMeetingService.validate(validateAttendMeetingInputDM);
    }
}
