package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
//import com.shaibal.meetings.steps.EnrichMeetingWithUserDetailsStep;
import com.shaibal.meetings.steps.PrepareValidateAddMeetingInputStep;
import com.shaibal.meetings.steps.notifications.NotifyMeetingAddedStep;
import com.shaibal.meetings.steps.PersistMeetingStep;
import com.shaibal.meetings.steps.validators.ValidateAddMeetingStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddMeetingApplicationService {

    private final PrepareValidateAddMeetingInputStep prepareValidateAddMeetingInputStep;
    private final ValidateAddMeetingStep validateAddMeetingStep;
    //private final EnrichMeetingWithUserDetailsStep enrichMeetingWithUserDetailsStep;
    private final PersistMeetingStep persistMeetingStep;
    private final NotifyMeetingAddedStep notifyMeetingAddedStep;

    public MeetingResponseDTO addMeeting(MeetingRequestDTO meetingRequestDTO, String jwtToken) throws Exception {
        Context context = initContext(meetingRequestDTO, jwtToken);

        prepareValidateAddMeetingInputStep.execute(context);
        validateAddMeetingStep.execute(context);
        persistMeetingStep.execute(context);
        notifyMeetingAddedStep.execute(context);

        return (MeetingResponseDTO) context.getValue(ResponseConstants.ADD_MEETING_RESPONSE);
    }

    public Context initContext(MeetingRequestDTO meetingRequestDTO, String authHeader) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_REQUEST_DTO, meetingRequestDTO);

        String jwtToken = authHeader.substring(7);

        context.setValue(ContextConstants.JWT_TOKEN, jwtToken);

        return context;
    }
}
