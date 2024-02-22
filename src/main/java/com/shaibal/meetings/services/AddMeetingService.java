package com.shaibal.meetings.services;

import com.shaibal.meetings.mappers.MeetingEntityToMeetingResponseDTOMapper;
import com.shaibal.meetings.mappers.MeetingDTOToMeetingMapper;
import com.shaibal.meetings.mappers.MeetingRequestDTOToMeetingDTOMapper;
import com.shaibal.meetings.models.Location;
import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMeetingService {

    private final MeetingRepository meetingRepository;
    private final MeetingEntityToMeetingResponseDTOMapper meetingEntityToMeetingResponseDTOMapper;
    private final MeetingDTOToMeetingMapper meetingDTOToMeetingMapper;
    private final MeetingRequestDTOToMeetingDTOMapper meetingRequestDTOToMeetingDTOMapper;

    public MeetingResponseDTO add(MeetingRequestDTO meetingRequestDTO) {
        // Map MeetingRequestDTO to MeetingDTO using the mapper
        MeetingDTO meetingDTO = meetingRequestDTOToMeetingDTOMapper.map(meetingRequestDTO);

        // Map MeetingDTO to Meeting entity
        Meeting meetingEntity = meetingDTOToMeetingMapper.apply(meetingDTO);

        // Save the Meeting entity to the repository
        meetingRepository.save(meetingEntity);

        // Map the saved Meeting entity to MeetingResponseDTO
        return meetingEntityToMeetingResponseDTOMapper.apply(meetingEntity);
    }
}
