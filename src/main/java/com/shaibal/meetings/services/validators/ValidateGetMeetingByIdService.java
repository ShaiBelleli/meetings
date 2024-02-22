package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateGetMeetingByIdService {

    private final MeetingRepository meetingRepository;

    public void validate(Long meetingId) throws Exception {
        meetingRepository.findById(meetingId).orElseThrow(() -> new Exception("Meeting with id " + meetingId + "not found."));
    }
}
