package com.shaibal.meetings.services;

import com.shaibal.meetings.mappers.MeetingAttendanceRequestEntityToMeetingAttendanceRequestResponseDTOMapper;
import com.shaibal.meetings.models.MeetingAttendanceRequestResponseDTO;
import com.shaibal.meetings.repositories.MeetingAttendanceRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetAllMeetingAttendanceRequestsService {
    private final MeetingAttendanceRequestRepository meetingAttendanceRequestRepository;
    private final MeetingAttendanceRequestEntityToMeetingAttendanceRequestResponseDTOMapper
            meetingAttendanceRequestEntityToMeetingAttendanceRequestResponseDTOMapper;

    public List<MeetingAttendanceRequestResponseDTO> getAllMeetingAttendanceRequests() {
        return meetingAttendanceRequestRepository.findAll()
                .stream()
                .map(meetingAttendanceRequestEntityToMeetingAttendanceRequestResponseDTOMapper::map)
                .collect(Collectors.toList());
    }


}
