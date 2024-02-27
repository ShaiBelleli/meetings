package com.shaibal.meetings.steps.validators;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.mappers.MeetingResponseDTOToMeetingDMMapper;
import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.GetMeetingService;
import com.shaibal.meetings.services.validators.ValidateAttendMeetingService;
import com.shaibal.meetings.steps.IStep;
import org.springframework.stereotype.Component;

@Component
public class ValidateAttendMeetingStep implements IStep {

    private final GetMeetingService getMeetingService;
    private final ValidateAttendMeetingService validateAttendMeetingService;
    private final MeetingResponseDTOToMeetingDMMapper meetingResponseDTOToMeetingDMMapper;

    public ValidateAttendMeetingStep(GetMeetingService getMeetingService, ValidateAttendMeetingService validateAttendMeetingService, MeetingResponseDTOToMeetingDMMapper meetingResponseDToToMeetingDMMapper) {
        this.getMeetingService = getMeetingService;
        this.validateAttendMeetingService = validateAttendMeetingService;
        this.meetingResponseDTOToMeetingDMMapper = meetingResponseDToToMeetingDMMapper;
    }

    @Override
    public void execute(Context context) throws Exception {
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);

        MeetingResponseDTO meetingResponseDTO = getMeetingService.getMeeting(meetingId);

        MeetingDM meetingDM = meetingResponseDTOToMeetingDMMapper.map(meetingResponseDTO);

        validateAttendMeetingService.validate(meetingDM);
    }
}
