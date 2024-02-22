package com.shaibal.meetings.delegates;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.application_services.AddMeetingApplicationService;
import com.shaibal.meetings.application_services.DeleteMeetingByIdApplicationService;
import com.shaibal.meetings.application_services.GetAllMeetingsApplicationService;
import com.shaibal.meetings.constants.BusinessConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingDelegate {
    private final Context context;
    private final GetAllMeetingsApplicationService getAllMeetingsApplicationService;
    private final AddMeetingApplicationService addMeetingApplicationService;
    private final DeleteMeetingByIdApplicationService deleteMeetingByIdApplicationService;

    public List<MeetingResponseDTO> getAllMeetings() {
        getAllMeetingsApplicationService.execute();

        return (List<MeetingResponseDTO>) context.getValue(ContextConstants.GET_ALL_MEETINGS_RESPONSE);
    }

    public MeetingResponseDTO addMeeting(MeetingRequestDTO meeting) {
        context.setValue(ContextConstants.MEETING_REQUEST_DTO_TO_ADD, meeting);

        addMeetingApplicationService.execute();

        return (MeetingResponseDTO) context.getValue(ContextConstants.MEETING_ADDED_RESPONSE);
    }

    public String deleteMeetingById(Long meetingId) throws Exception {
        context.setValue(ContextConstants.MEETING_ID_TO_DELETE, meetingId);

        deleteMeetingByIdApplicationService.execute();

        return (String) context.getValue(BusinessConstants.MEETING_DELETED_SUCCESSFULLY);
    }

    public String attendMeeting(Long meetingId) throws Exception {
        context.setValue(ContextConstants.MEETING_ID_TO_ATTEND, meetingId);

        attendMeetingApplicationService.execute();

        return (String) context.getValue(BusinessConstants.ATTEND_MEETING_RESPONSE);
    }
}
