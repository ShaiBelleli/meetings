package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.steps.AttendMeetingStep;
import com.shaibal.meetings.steps.notifications.NotifyMeetingAttendedStep;
import com.shaibal.meetings.steps.validators.ValidateAttendMeetingStep;
import org.springframework.stereotype.Component;

@Component
public class AttendMeetingApplicationService {

    ValidateAttendMeetingStep validateAttendMeetingStep;
    AttendMeetingStep attendMeetingStep;
    NotifyMeetingAttendedStep notifyMeetingAttendedStep;

    public String attendMeeting(Long meetingId) throws Exception {
        Context context = initContext(meetingId);

        validateAttendMeetingStep.execute(context);
        attendMeetingStep.execute(context);
        notifyMeetingAttendedStep.execute(context);

        return (String) context.getValue(ResponseConstants.ATTEND_MEETING_RESPONSE);
    }

    public Context initContext(Long meetingId) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);

        return context;
    }
}
