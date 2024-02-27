package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.BusinessConstants;
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

    public String deleteMeeting(String meetingId) throws Exception {
        Context context = initContext(meetingId);

        validateDeleteMeetingByIdStep.execute(context);
        deleteMeetingFromDbStep.execute(context);
        notifyMeetingDeletedStep.execute(context);

        return (String) context.getValue(ResponseConstants.DELETE_MEETING_RESPONSE);
    }

    public Context initContext(String meetingId) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);
        context.setValue(ResponseConstants.DELETE_MEETING_RESPONSE, BusinessConstants.MEETING_DELETED_MSG);

        return context;
    }
}
