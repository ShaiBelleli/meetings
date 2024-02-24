package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.services.DeleteMeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMeetingFromDbStep implements IStep {

    private final DeleteMeetingService deleteMeetingService;

    @Override
    public void execute(Context context) {
        deleteMeetingService.delete((Long) context.getValue(ContextConstants.MEETING_ID));
    }
}
