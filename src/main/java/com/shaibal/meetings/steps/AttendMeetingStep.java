package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.BusinessConstants;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.input.AttendMeetingServiceInputDM;
import com.shaibal.meetings.services.AttendMeetingService;
import com.shaibal.meetings.services.GetMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AttendMeetingStep implements IStep {

    private final AttendMeetingService attendMeetingService;
    @Override
    public void execute(Context context) throws Exception {
        MeetingResponseDTO meetingDTO = (MeetingResponseDTO) context.getValue(ContextConstants.MEETING_DTO);
        AttendMeetingServiceInputDM attendMeetingServiceInputDM = (AttendMeetingServiceInputDM) context.getValue(ContextConstants.ATTEND_MEETING_SERVICE_INPUT_DM);

        Set<String> attendeesToAdd = attendMeetingService.attendMeeting(attendMeetingServiceInputDM);

        if (Boolean.TRUE.equals(attendMeetingServiceInputDM.getIsPendingRequired())) {
            meetingDTO.setPendingAttendees(attendeesToAdd);
            context.setValue(ResponseConstants.ATTEND_MEETING_RESPONSE, BusinessConstants.ADDED_TO_PENDING_ATTENDEES_MSG);
        }

        else {
            meetingDTO.setAttendees(attendeesToAdd);
            context.setValue(ResponseConstants.ATTEND_MEETING_RESPONSE, BusinessConstants.ADDED_TO_ATTENDEES_MSG);
        }

        context.setValue(ContextConstants.MEETING_DTO_AFTER_ATTEND_UPDATE, meetingDTO);
    }
}
