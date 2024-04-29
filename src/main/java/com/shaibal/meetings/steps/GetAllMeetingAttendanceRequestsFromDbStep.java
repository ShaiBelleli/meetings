package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.models.MeetingAttendanceRequestResponseDTO;
import com.shaibal.meetings.services.GetAllMeetingAttendanceRequestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllMeetingAttendanceRequestsFromDbStep implements IStep {

    private final GetAllMeetingAttendanceRequestsService getAllMeetingAttendanceRequestsService;
    @Override
    public void execute(Context context) throws Exception {
        List<MeetingAttendanceRequestResponseDTO> meetingAttendanceRequestResponses =
                getAllMeetingAttendanceRequestsService.getAllMeetingAttendanceRequests();

        context.setValue(ResponseConstants.GET_ALL_MEETING_ATTENDANCE_REQUESTS_RESPONSE, meetingAttendanceRequestResponses);
    }
}
