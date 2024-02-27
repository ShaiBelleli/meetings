package com.shaibal.meetings.services;

import com.shaibal.meetings.mappers.MeetingEntityToMeetingResponseDTOMapper;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GetMeetingService {

    private final MeetingRepository meetingRepository;
    private final MeetingEntityToMeetingResponseDTOMapper meetingEntityToMeetingResponseDTOMapper;

    public GetMeetingService(MeetingRepository meetingRepository, MeetingEntityToMeetingResponseDTOMapper meetingEntityToMeetingResponseDTOMapper) {
        this.meetingRepository = meetingRepository;
        this.meetingEntityToMeetingResponseDTOMapper = meetingEntityToMeetingResponseDTOMapper;
    }

    public MeetingResponseDTO getMeeting(String meetingId) {
        return meetingRepository.findById(meetingId)
                .map(meetingEntityToMeetingResponseDTOMapper::map)
                .orElseThrow(() -> new NoSuchElementException("Meeting with id " + meetingId + " not found"));
    }
}
