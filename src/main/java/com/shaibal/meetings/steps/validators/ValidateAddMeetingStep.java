package com.shaibal.meetings.steps.validators;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.services.validators.ValidateAddMeetingService;
import com.shaibal.meetings.steps.IStep;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateAddMeetingStep implements IStep {

    private final ValidateAddMeetingService validateAddMeetingService;

    @Override
    public void execute(Context context) throws BadRequestException {
        MeetingRequestDTO meetingToAdd = (MeetingRequestDTO) context.getValue(ContextConstants.MEETING_REQUEST_DTO);

        validateAddMeetingService.validate(meetingToAdd);
    }
}
