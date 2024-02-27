package com.shaibal.meetings.services;

import com.shaibal.meetings.mappers.MeetingEntityToMeetingResponseDTOMapper;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetMeetingService {

    private final MeetingRepository meetingRepository;
    private final MeetingEntityToMeetingResponseDTOMapper meetingEntityToMeetingResponseDTOMapper;

    public MeetingResponseDTO getMeeting(String meetingId) {
        return meetingRepository.findById(meetingId)
                .map(meetingEntityToMeetingResponseDTOMapper::map)
                .orElseThrow(() -> new NoSuchElementException("Meeting with id " + meetingId + " not found"));
    }
}
