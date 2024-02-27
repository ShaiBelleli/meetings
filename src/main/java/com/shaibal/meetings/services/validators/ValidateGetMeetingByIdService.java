package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ValidateGetMeetingByIdService {

    private final MeetingRepository meetingRepository;

    public void validate(String meetingId) throws Exception {
        meetingRepository.findById(meetingId).orElseThrow(() -> new NoSuchElementException("Meeting with id " + meetingId + "not found."));
    }
}
