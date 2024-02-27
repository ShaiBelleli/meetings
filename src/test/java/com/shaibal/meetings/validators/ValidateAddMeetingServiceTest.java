package com.shaibal.meetings.validators;

import com.shaibal.meetings.models.Location;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.services.validators.ValidateAddMeetingService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ValidateAddMeetingServiceTest {

    @InjectMocks
    private ValidateAddMeetingService validateAddMeetingService;

    @Test
    void validate_StartDateNotExpired() throws BadRequestException {
        // Mocking
        MeetingRequestDTO requestDTO = new MeetingRequestDTO();
        Location location = new Location("location_1", (1.0), (1.0));

        requestDTO.setStartTime(LocalDateTime.now().plusHours(1)); // Set the start time to be in the future
        requestDTO.setTitle("meeting_1");
        requestDTO.setLocation(location);

        // Test
        validateAddMeetingService.validate(requestDTO);
    }

    @Test
    void validate_StartDateExpired_ThrowsException() {
        // Mocking
        MeetingRequestDTO requestDTO = new MeetingRequestDTO();
        Location location = new Location("location_1", (1.0), (1.0));

        requestDTO.setStartTime(LocalDateTime.now().minusHours(1)); // Set the start time to be in the past
        requestDTO.setTitle("meeting_1");
        requestDTO.setLocation(location);

        // Test
        assertThrows(IllegalArgumentException.class, () -> validateAddMeetingService.validate(requestDTO));
    }
}
