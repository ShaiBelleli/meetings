package com.shaibal.meetings.validators;

import com.shaibal.meetings.services.validators.ValidateDeleteMeetingByIdService;
import com.shaibal.meetings.services.validators.ValidateGetMeetingByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ValidateDeleteMeetingByIdServiceTest {

    @InjectMocks
    private ValidateDeleteMeetingByIdService validateDeleteMeetingByIdService;

    @Mock
    private ValidateGetMeetingByIdService validateGetMeetingByIdService;

    @Test
    void validate_IdExistsInDb() throws Exception {
        // Mocking
        Long meetingId = 1L;

        // Test
        validateDeleteMeetingByIdService.validate(meetingId);

        // Verify that validateGetMeetingByIdService.validate was called with the correct argument
        verify(validateGetMeetingByIdService).validate(meetingId);
    }

    @Test
    void validate_IdDoesNotExistInDb_ThrowsException() throws Exception {
        // Mocking
        Long meetingId = 2L;
        // Assuming validateGetMeetingByIdService.validate throws an exception when the ID doesn't exist
        doThrow(new Exception("Meeting not found")).when(validateGetMeetingByIdService).validate(meetingId);

        // Test
        assertThrows(Exception.class, () -> validateDeleteMeetingByIdService.validate(meetingId));
    }
}

