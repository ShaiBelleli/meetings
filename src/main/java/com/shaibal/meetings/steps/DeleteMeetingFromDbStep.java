package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.BusinessConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.DeleteMeetingService;
import com.shaibal.meetings.services.GetMeetingService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMeetingFromDbStep implements IStep {

    private final DeleteMeetingService deleteMeetingService;

    @Override
    public void execute(Context context) {
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);

        deleteMeetingService.delete(meetingId);
    }
}
