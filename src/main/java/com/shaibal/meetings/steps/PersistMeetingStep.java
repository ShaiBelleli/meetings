package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.AddMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistMeetingStep implements IStep {

    private final AddMeetingService addMeetingService;

    @Override
    public void execute(Context context) {

        MeetingDTO meetingDTO = (MeetingDTO) context.getValue(ContextConstants.MEETING_DTO_AFTER_USER_DETAILS_ENRICHMENT);

        MeetingResponseDTO meetingResponseDTO = addMeetingService.add(meetingDTO);

        context.setValue(ResponseConstants.ADD_MEETING_RESPONSE, meetingResponseDTO);
    }
}
