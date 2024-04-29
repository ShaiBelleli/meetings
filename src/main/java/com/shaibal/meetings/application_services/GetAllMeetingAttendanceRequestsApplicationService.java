package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.models.MeetingAttendanceRequestResponseDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.steps.GetAllMeetingAttendanceRequestsFromDbStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllMeetingAttendanceRequestsApplicationService {

    private final GetAllMeetingAttendanceRequestsFromDbStep getAllMeetingAttendanceRequestsFromDbStep;

    public List<MeetingAttendanceRequestResponseDTO> getAllMeetingAttendanceRequests() throws Exception {
        Context context = initContext();

        getAllMeetingAttendanceRequestsFromDbStep.execute(context);

        return (List<MeetingAttendanceRequestResponseDTO>) context.getValue(ResponseConstants.GET_ALL_MEETING_ATTENDANCE_REQUESTS_RESPONSE);
    }

    private Context initContext() {
        Context context = new Context();

        return context;
    }
}
