package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.Location;
import com.shaibal.meetings.models.MeetingDTO;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.services.LocationService;
import org.springframework.stereotype.Component;

@Component
public class MeetingRequestDTOToMeetingDTOMapper implements IMapper<MeetingDTO, MeetingRequestDTO> {

    private final LocationService locationService;

    public MeetingRequestDTOToMeetingDTOMapper(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public MeetingDTO map(MeetingRequestDTO meetingRequestDTO) {
        // Build Location from user input using the injected LocationService
        Location location = locationService.buildLocationFromStringsInput(
                meetingRequestDTO.getCity(),
                meetingRequestDTO.getStreet(),
                meetingRequestDTO.getStreetNumber()
        );

        // Map MeetingRequestDTO to MeetingDTO
        return MeetingDTO.builder()
                .organizer(meetingRequestDTO.getOrganizer())
                .title(meetingRequestDTO.getTitle())
                .numberOfPeopleLimit(meetingRequestDTO.getNumberOfPeopleLimit())
                .startTime(meetingRequestDTO.getStartTime())
                .minAge(meetingRequestDTO.getMinAge())
                .maxAge(meetingRequestDTO.getMaxAge())
                .location(location)
                .purpose(meetingRequestDTO.getPurpose())
                .freeText(meetingRequestDTO.getFreeText())
                .build();
    }
}
