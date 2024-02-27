package com.shaibal.meetings.validators;

import com.shaibal.meetings.models.entities.Meeting;
import com.shaibal.meetings.repositories.MeetingRepository;
import com.shaibal.meetings.services.validators.ValidateGetMeetingByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidateGetMeetingByIdServiceTest {

    @Mock
    private MeetingRepository meetingRepository;

    @InjectMocks
    private ValidateGetMeetingByIdService validateGetMeetingByIdService;

    @Test
    void validateMeetingExists() throws Exception {
        // Arrange
        String meetingId = "1";
        Meeting validMeeting = new Meeting();
        when(meetingRepository.findById(meetingId)).thenReturn(Optional.of(validMeeting));

        // Act
        validateGetMeetingByIdService.validate(meetingId);

        // No assertion needed, if the method completes without throwing an exception, the test passes
    }

    @Test
    void validateMeetingNotFound() {
        // Arrange
        String meetingId = "1";
        when(meetingRepository.findById(meetingId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(Exception.class, () -> validateGetMeetingByIdService.validate(meetingId));
    }
}
