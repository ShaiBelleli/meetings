package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import com.shaibal.meetings.steps.AddUserToPendingAttendeesStep;
import com.shaibal.meetings.steps.NotifyMeetingAttendanceRequestStep;
import com.shaibal.meetings.steps.PersistMeetingAttendanceRequestStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateMeetingAttendanceRequestApplicationService {

    private final AddUserToPendingAttendeesStep addUserToPendingAttendeesStep;
    private final PersistMeetingAttendanceRequestStep persistMeetingAttendanceRequestStep;
    private final NotifyMeetingAttendanceRequestStep notifyMeetingAttendanceRequestStep;

    public void createMeetingAttendanceRequest(CreateMeetingAttendanceRequestInputDM createMeetingAttendanceRequestInputDM) throws Exception {
        // build context or take it from triggering code?
        Context context = initContext(createMeetingAttendanceRequestInputDM);

        addUserToPendingAttendeesStep.execute(context);
        persistMeetingAttendanceRequestStep.execute(context);
        notifyMeetingAttendanceRequestStep.execute(context);
    }

    public Context initContext(CreateMeetingAttendanceRequestInputDM createMeetingAttendanceRequestInputDM) {
        Context context = new Context();

        context.setValue(ContextConstants.CREATE_MEETING_ATTENDANCE_REQUEST_INPUT, createMeetingAttendanceRequestInputDM);

        return context;
    }
}
