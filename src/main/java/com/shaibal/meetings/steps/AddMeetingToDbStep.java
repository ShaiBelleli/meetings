package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.AddMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddMeetingToDbStep implements IStep {

    private final AddMeetingService addMeetingService;

    @Override
    public void execute(Context context) {
        MeetingRequestDTO meetingRequestDTO = (MeetingRequestDTO) context.getValue(ContextConstants.MEETING_REQUEST_DTO);

        MeetingResponseDTO meetingResponseDTO = addMeetingService.add(meetingRequestDTO);

        context.setValue(ResponseConstants.ADD_MEETING_RESPONSE, meetingResponseDTO);
    }
}
