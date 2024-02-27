package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.steps.GetMeetingFromDbStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMeetingApplicationService {

    private final GetMeetingFromDbStep getMeetingFromDbStep;

    public MeetingResponseDTO getMeeting(String meetingId) throws Exception {
        Context context = initContext(meetingId);

//        validateGetMeetingStep.execute(context);
        getMeetingFromDbStep.execute(context);

        return (MeetingResponseDTO) context.getValue(ResponseConstants.GET_MEETING_RESPONSE);
    }

    public Context initContext(String meetingId) {
        Context context = new Context();

        context.setValue(ContextConstants.MEETING_ID, meetingId);

        return context;
    }
}
