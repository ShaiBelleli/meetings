package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.PersistAttendMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistAttendMeetingStep implements IStep {

    private final PersistAttendMeetingService persistAttendMeetingService;
    @Override
    public void execute(Context context) throws Exception {
        MeetingResponseDTO meetingDTOToPersist = (MeetingResponseDTO) context.getValue(ContextConstants.MEETING_DTO_AFTER_ATTEND_UPDATE);

        persistAttendMeetingService.persistMeeting(meetingDTOToPersist);
    }
}
