package com.shaibal.meetings.services;

import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMeetingService {

    private final MeetingRepository meetingRepository;

    public void delete(String meetingId) {
        meetingRepository.deleteById(meetingId);
    }
}
