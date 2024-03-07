package com.shaibal.meetings.services;

import com.shaibal.meetings.mappers.MeetingResponseDTOMeetingEntityMapper;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistAttendMeetingService {
    private final MeetingRepository meetingRepository;

    public void persistMeeting(MeetingResponseDTO meetingResponseDTO) {
        Meeting meeting = MeetingResponseDTOMeetingEntityMapper.INSTANCE.toMeeting(meetingResponseDTO);

        meetingRepository.save(meeting);
    }
}
