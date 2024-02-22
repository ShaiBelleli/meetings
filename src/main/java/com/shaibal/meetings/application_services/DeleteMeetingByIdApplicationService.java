package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.steps.DeleteMeetingFromDbStep;
import com.shaibal.meetings.steps.validators.ValidateDeleteMeetingByIdStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMeetingByIdApplicationService implements IApplicationService {

    private final Context context;
    private final DeleteMeetingFromDbStep deleteMeetingFromDbStep;
    private final ValidateDeleteMeetingByIdStep validateDeleteMeetingByIdStep;

    @Override
    public void execute() throws Exception {
        validateDeleteMeetingByIdStep.execute(context);
        deleteMeetingFromDbStep.execute(context);
    }
}
