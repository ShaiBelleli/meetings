package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.input.CreateMeetingAttendanceRequestInputDM;
import com.shaibal.meetings.security.users.User;
import org.springframework.stereotype.Component;

@Component
public class PrepareCreateMeetingAttendanceRequestInputStep implements IStep {
    @Override
    public void execute(Context context) throws Exception {
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);
        User userDetails = (User) context.getValue(ContextConstants.USER_DETAILS);

        CreateMeetingAttendanceRequestInputDM createMeetingAttendanceRequestInputDM =
                CreateMeetingAttendanceRequestInputDM.builder()
                        .meetingId(meetingId)
                        .userAge(userDetails.getAge())
                        .instagramUrl(userDetails.getInstagramUrl())
                        .userDisplayName(userDetails.getDisplayName())
                        .build();

        context.setValue(ContextConstants.CREATE_MEETING_ATTENDANCE_REQUEST_INPUT, createMeetingAttendanceRequestInputDM);
    }
}
