package com.shaibal.meetings.steps;

import com.shaibal.meetings.Context;
import com.shaibal.meetings.constants.ContextConstants;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.services.GetAllMeetingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllMeetingsFromDbStep implements IStep {

    private final GetAllMeetingsService getAllMeetings;

    @Override
    public void execute(Context context) {
        List<MeetingResponseDTO> meetings = getAllMeetings.get();
        context.setValue(ContextConstants.GET_ALL_MEETINGS_RESPONSE, meetings);
    }
}
