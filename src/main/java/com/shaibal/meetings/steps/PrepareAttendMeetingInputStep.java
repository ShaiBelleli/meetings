package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.input.AttendMeetingServiceInputDM;
import com.shaibal.meetings.services.GetMeetingService;
import com.shaibal.meetings.services.PrepareAttendMeetingInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrepareAttendMeetingInputStep implements IStep {

    private final PrepareAttendMeetingInputService prepareAttendMeetingInputService;
    @Override
    public void execute(Context context) throws Exception {
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);
        String jwtToken = (String) context.getValue(ContextConstants.JWT_TOKEN);

        AttendMeetingServiceInputDM attendMeetingServiceInputDM = prepareAttendMeetingInputService.prepareInput(meetingId, jwtToken);

        context.setValue(ContextConstants.ATTEND_MEETING_SERVICE_INPUT_DM, attendMeetingServiceInputDM);
    }
}
