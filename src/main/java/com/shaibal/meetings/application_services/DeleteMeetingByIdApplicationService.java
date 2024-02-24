package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.steps.DeleteMeetingFromDbStep;
import com.shaibal.meetings.steps.notifications.NotifyMeetingDeletedStep;
import com.shaibal.meetings.steps.validators.ValidateDeleteMeetingByIdStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMeetingByIdApplicationService {

    private final DeleteMeetingFromDbStep deleteMeetingFromDbStep;
    private final ValidateDeleteMeetingByIdStep validateDeleteMeetingByIdStep;
    private final NotifyMeetingDeletedStep notifyMeetingDeletedStep;

    public String deleteMeeting(Long meetingId) throws Exception {
        Context context = initContext(meetingId);

        validateDeleteMeetingByIdStep.execute(context);
        deleteMeetingFromDbStep.execute(context);
        notifyMeetingDeletedStep.execute(context);

        return (String) context.getValue(ResponseConstants.DELETE_MEETING_RESPONSE);
    }

    public Context initContext(Long meetingId) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);

        return context;
    }
}
