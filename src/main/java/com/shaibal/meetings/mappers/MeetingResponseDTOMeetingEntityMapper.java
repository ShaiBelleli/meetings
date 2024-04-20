package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.models.entities.Meeting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeetingResponseDTOMeetingEntityMapper {

    MeetingResponseDTOMeetingEntityMapper INSTANCE = Mappers.getMapper(MeetingResponseDTOMeetingEntityMapper.class);

    Meeting toMeeting(MeetingResponseDTO meetingResponseDTO);

    MeetingResponseDTO toMeetingResponseDTO(Meeting meeting);
}