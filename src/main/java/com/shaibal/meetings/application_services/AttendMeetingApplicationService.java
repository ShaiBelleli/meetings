package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.steps.AttendMeetingStep;
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

    public String attendMeeting(String meetingId) throws Exception {
        Context context = initContext(meetingId);

        validateAttendMeetingStep.execute(context);
        attendMeetingStep.execute(context);
        notifyMeetingAttendedStep.execute(context);

        return (String) context.getValue(ResponseConstants.ATTEND_MEETING_RESPONSE);
    }

    public Context initContext(String meetingId) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);

        return context;
    }
}
