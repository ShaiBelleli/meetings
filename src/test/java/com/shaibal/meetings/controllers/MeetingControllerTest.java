package com.shaibal.meetings.controllers;

import com.shaibal.meetings.delegates.MeetingDelegate;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MeetingControllerTest {

    @InjectMocks
    private MeetingController meetingController;

    @Mock
    private MeetingDelegate meetingDelegate;

    @Test
    void addMeeting_ReturnsOkResponse() {
        // Mocking
        MeetingRequestDTO requestDTO = new MeetingRequestDTO();
        MeetingResponseDTO responseDTO = new MeetingResponseDTO();
        when(meetingDelegate.addMeeting(any(MeetingRequestDTO.class))).thenReturn(responseDTO);

        // Test
        ResponseEntity<MeetingResponseDTO> response = meetingController.add(requestDTO);

        // Verify
        verify(meetingDelegate).addMeeting(requestDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseDTO, response.getBody());
    }
}
