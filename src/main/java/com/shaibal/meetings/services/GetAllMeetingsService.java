package com.shaibal.meetings.services;

import com.shaibal.meetings.mappers.MeetingEntityToMeetingResponseDTOMapper;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllMeetingsService {
    private final MeetingRepository meetingRepository;
    private final MeetingEntityToMeetingResponseDTOMapper meetingEntityToMeetingResponseDTOMapper;

    public List<MeetingResponseDTO> get() {
        return meetingRepository.findAll()
                .stream()
                .map(meetingEntityToMeetingResponseDTOMapper::map)
                .collect(Collectors.toList());
    }
}
