package com.shaibal.meetings.services.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateDeleteMeetingByIdService {

    private final ValidateGetMeetingByIdService validateGetMeetingByIdService;

    public void validate(String meetingId) throws Exception {
        validateIdExistsInDb(meetingId);
    }

    private void validateIdExistsInDb(String meetingId) throws Exception {
        validateGetMeetingByIdService.validate(meetingId);
    }
}
