package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class GetMeetingApplicationService {

    public MeetingResponseDTO getMeeting(Long meetingId) throws Exception {
        Context context = initContext(meetingId);

//        validateGetMeetingStep.execute(context);
//        getMeetingFromDbStep.execute(context);

        return (MeetingResponseDTO) context.getValue(ResponseConstants.GET_MEETING_RESPONSE);
    }

    public Context initContext(Long meetingId) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);

        return context;
    }
}
