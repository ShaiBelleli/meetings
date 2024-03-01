package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.steps.EnrichMeetingWithUserDetailsStep;
import com.shaibal.meetings.steps.notifications.NotifyMeetingAddedStep;
import com.shaibal.meetings.steps.AddMeetingToDbStep;
import com.shaibal.meetings.steps.validators.ValidateAddMeetingStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddMeetingApplicationService {

    private final ValidateAddMeetingStep validateAddMeetingStep;
    private final EnrichMeetingWithUserDetailsStep enrichMeetingWithUserDetailsStep;
    private final AddMeetingToDbStep addMeetingToDbStep;
    private final NotifyMeetingAddedStep notifyMeetingAddedStep;

    public MeetingResponseDTO addMeeting(MeetingRequestDTO meetingRequestDTO, String jwtToken) throws Exception {
        Context context = initContext(meetingRequestDTO, jwtToken);

        validateAddMeetingStep.execute(context);
        enrichMeetingWithUserDetailsStep.execute(context);
        addMeetingToDbStep.execute(context);
        notifyMeetingAddedStep.execute(context);

        return (MeetingResponseDTO) context.getValue(ResponseConstants.ADD_MEETING_RESPONSE);
    }

    public Context initContext(MeetingRequestDTO meetingRequestDTO, String jwtToken) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_REQUEST_DTO, meetingRequestDTO);
        context.setValue(ContextConstants.JWT_TOKEN, jwtToken);

        return context;
    }
}
