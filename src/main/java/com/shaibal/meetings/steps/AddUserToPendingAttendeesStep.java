package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.mappers.MeetingDMToMeetingEntityMapper;
import com.shaibal.meetings.mappers.MeetingResponseDTOToMeetingDMMapper;
import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import com.shaibal.meetings.repositories.MeetingRepository;
import com.shaibal.meetings.services.AddMeetingService;
import com.shaibal.meetings.services.AddUserToPendingAttendeesService;
import com.shaibal.meetings.services.GetMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddUserToPendingAttendeesStep implements IStep {
    private final AddUserToPendingAttendeesService addUserToPendingAttendeesService;
    private final GetMeetingService getMeetingService;
    private final MeetingResponseDTOToMeetingDMMapper meetingResponseDTOToMeetingDMMapper;
    private final MeetingDMToMeetingEntityMapper meetingDMToMeetingEntityMapper;
    private final MeetingRepository meetingRepository;
    @Override
    public void execute(Context context) throws Exception {
        CreateMeetingAttendanceRequestInputDM createMeetingAttendanceRequestInputDM = (CreateMeetingAttendanceRequestInputDM) context.getValue(ContextConstants.CREATE_MEETING_ATTENDANCE_REQUEST_INPUT);

        String userDisplayName = createMeetingAttendanceRequestInputDM.getUserDisplayName();
        MeetingResponseDTO meetingDTO = getMeetingService.getMeeting(createMeetingAttendanceRequestInputDM.getMeetingId());
        MeetingDM meetingDM = meetingResponseDTOToMeetingDMMapper.map(meetingDTO);

        addUserToPendingAttendeesService.addUserToPendingAttendees(userDisplayName, meetingDM);

        Meeting meetingEntity = meetingDMToMeetingEntityMapper.map(meetingDM);

        meetingRepository.save(meetingEntity);
    }
}
