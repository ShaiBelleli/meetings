package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingAttendanceRequestResponseDTO;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import com.shaibal.meetings.services.AddMeetingAttendanceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistMeetingAttendanceRequestStep implements IStep {

    private final AddMeetingAttendanceRequestService addMeetingAttendanceRequestService;
    @Override
    public void execute(Context context) throws Exception {
        CreateMeetingAttendanceRequestInputDM createMeetingAttendanceRequestInputDM =
                (CreateMeetingAttendanceRequestInputDM) context.getValue(ContextConstants.CREATE_MEETING_ATTENDANCE_REQUEST_INPUT);

        MeetingAttendanceRequestResponseDTO meetingAttendanceRequestResponseDTO =
                addMeetingAttendanceRequestService.add(createMeetingAttendanceRequestInputDM);

        context.setValue(ContextConstants.MEETING_ATTENDANCE_REQUEST_RESPONSE, meetingAttendanceRequestResponseDTO);
    }
}
