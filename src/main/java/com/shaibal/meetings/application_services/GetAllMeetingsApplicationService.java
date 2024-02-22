package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.steps.GetAllMeetingsFromDbStep;
import com.shaibal.meetings.steps.validators.ValidateGetAllMeetingsStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAllMeetingsApplicationService implements IApplicationService {

    private final Context context;
    private final ValidateGetAllMeetingsStep validateGetAllMeetingsStep;
    private final GetAllMeetingsFromDbStep getAllMeetingsFromDbStep;

    @Override
    public void execute() {
        validateGetAllMeetingsStep.execute(context);
        getAllMeetingsFromDbStep.execute(context);
    }
}
