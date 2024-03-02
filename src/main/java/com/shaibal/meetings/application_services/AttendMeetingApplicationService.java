package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.steps.AttendMeetingStep;
import com.shaibal.meetings.steps.PrepareValidateAttendMeetingInputStep;
import com.shaibal.meetings.steps.notifications.NotifyMeetingAttendedStep;
import com.shaibal.meetings.steps.validators.ValidateAttendMeetingStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendMeetingApplicationService {

    private final ValidateAttendMeetingStep validateAttendMeetingStep;
    private final AttendMeetingStep attendMeetingStep;
    private final NotifyMeetingAttendedStep notifyMeetingAttendedStep;
    private final PrepareValidateAttendMeetingInputStep prepareValidateAttendMeetingInputStep;

    public String attendMeeting(String meetingId, String authHeader) throws Exception {
        Context context = initContext(meetingId, authHeader);

        prepareValidateAttendMeetingInputStep.execute(context);
        validateAttendMeetingStep.execute(context);
        attendMeetingStep.execute(context);
        notifyMeetingAttendedStep.execute(context);

        return (String) context.getValue(ResponseConstants.ATTEND_MEETING_RESPONSE);
    }

    public Context initContext(String meetingId, String authHeader) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);

        String jwtToken = authHeader.substring(7);

        context.setValue(ContextConstants.JWT_TOKEN, jwtToken);

        return context;
    }
}
