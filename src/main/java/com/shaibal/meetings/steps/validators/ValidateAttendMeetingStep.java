package com.shaibal.meetings.steps.validators;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.input.ValidateAttendMeetingInputDM;
import com.shaibal.meetings.services.validators.ValidateAttendMeetingService;
import com.shaibal.meetings.steps.IStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateAttendMeetingStep implements IStep {
    private final ValidateAttendMeetingService validateAttendMeetingService;

    @Override
    public void execute(Context context) throws Exception {
        ValidateAttendMeetingInputDM validateAttendMeetingInputDM = (ValidateAttendMeetingInputDM) context.getValue(ContextConstants.VALIDATE_ATTEND_MEETING_INPUT_DM);

        validateAttendMeetingService.validate(validateAttendMeetingInputDM);
    }
}
