package com.shaibal.meetings.steps.validators;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.services.validators.ValidateDeleteMeetingByIdService;
import com.shaibal.meetings.steps.IStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateDeleteMeetingByIdStep implements IStep {

    private final ValidateDeleteMeetingByIdService validateDeleteMeetingByIdService;

    @Override
    public void execute(Context context) throws Exception {
        String meetingId = (String) context.getValue(ContextConstants.MEETING_ID);
        validateDeleteMeetingByIdService.validate(meetingId);
    }
}
