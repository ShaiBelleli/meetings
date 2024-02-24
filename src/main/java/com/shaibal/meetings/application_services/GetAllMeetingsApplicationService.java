package com.shaibal.meetings.application_services;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ResponseConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.steps.GetAllMeetingsFromDbStep;
import com.shaibal.meetings.steps.validators.ValidateGetAllMeetingsStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllMeetingsApplicationService {

    private final ValidateGetAllMeetingsStep validateGetAllMeetingsStep;
    private final GetAllMeetingsFromDbStep getAllMeetingsFromDbStep;

    public List<MeetingResponseDTO> getAllMeetings() {
        Context context = initContext();

        validateGetAllMeetingsStep.execute(context);
        getAllMeetingsFromDbStep.execute(context);

        return (List<MeetingResponseDTO>) context.getValue(ResponseConstants.GET_ALL_MEETINGS_RESPONSE);
    }

    public Context initContext() {
        Context context = new Context();

        return context;
    }
}
