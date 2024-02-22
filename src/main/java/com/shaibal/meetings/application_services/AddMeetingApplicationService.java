package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.steps.AddMeetingToDbStep;
import com.shaibal.meetings.steps.validators.ValidateAddMeetingStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddMeetingApplicationService implements IApplicationService {

    private final Context context;
    private final AddMeetingToDbStep addMeetingToDbStep;
    private final ValidateAddMeetingStep validateAddMeetingStep;

    @Override
    public void execute() {
        validateAddMeetingStep.execute(context);
        addMeetingToDbStep.execute(context);
    }
}
