package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.GetMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMeetingFromDbStep implements IStep {

    private final GetMeetingService getMeetingService;

    @Override
    public void execute(Context context) throws Exception {
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);

        MeetingResponseDTO meetingResponseDTO = getMeetingService.getMeeting(meetingId);

        context.setValue(ResponseConstants.GET_MEETING_RESPONSE, meetingResponseDTO);
    }
}
