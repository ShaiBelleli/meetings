package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import com.shaibal.meetings.models.input.ValidateAttendMeetingInputDM;
import com.shaibal.meetings.security.users.User;
import com.shaibal.meetings.services.GetMeetingService;
import com.shaibal.meetings.steps.*;
import com.shaibal.meetings.steps.notifications.NotifyMeetingAttendedStep;
import com.shaibal.meetings.steps.validators.ValidateAttendMeetingStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendMeetingApplicationService {

    private final PrepareValidateAttendMeetingInputStep prepareValidateAttendMeetingInputStep;
    private final ValidateAttendMeetingStep validateAttendMeetingStep;
    private final PrepareAttendMeetingInputStep prepareAttendMeetingInputStep;
    private final AttendMeetingStep attendMeetingStep;
    private final PersistAttendMeetingStep persistAttendMeetingStep;
    private final NotifyMeetingAttendedStep notifyMeetingAttendedStep;
    private final PrepareCreateMeetingAttendanceRequestInputStep prepareCreateMeetingAttendanceRequestInputStep;
    private final CreateMeetingAttendanceRequestApplicationService createMeetingAttendanceRequestApplicationService;
    private final GetMeetingService getMeetingService;


    public String attendMeeting(String meetingId, String authHeader) throws Exception {
        Context context = initContext(meetingId, authHeader);

        prepareValidateAttendMeetingInputStep.execute(context);
        validateAttendMeetingStep.execute(context);
        if (Boolean.TRUE.equals(getMeetingService.getMeeting(meetingId).getIsPendingRequired())) {
            prepareCreateMeetingAttendanceRequestInputStep.execute(context);
            createMeetingAttendanceRequestApplicationService.createMeetingAttendanceRequest(
                    (CreateMeetingAttendanceRequestInputDM) context.getValue(ContextConstants.CREATE_MEETING_ATTENDANCE_REQUEST_INPUT));
            return (String) context.getValue(ResponseConstants.PENDING_MEETING_RESPONSE);
        }
        prepareAttendMeetingInputStep.execute(context);
        attendMeetingStep.execute(context);
        persistAttendMeetingStep.execute(context);
        notifyMeetingAttendedStep.execute(context);

        return (String) context.getValue(ResponseConstants.ATTEND_MEETING_RESPONSE);
    }

    public Context initContext(String meetingId, String authHeader) {
        Context context = new Context();
        String jwtToken = authHeader.substring(7);

        context.setValue(ContextConstants.MEETING_ID, meetingId);
        context.setValue(ContextConstants.JWT_TOKEN, jwtToken);

        return context;
    }
}
