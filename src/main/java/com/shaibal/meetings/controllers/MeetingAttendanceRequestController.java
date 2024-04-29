package com.shaibal.meetings.controllers;

import com.shaibal.meetings.application_services.GetAllMeetingAttendanceRequestsApplicationService;
import com.shaibal.meetings.models.MeetingAttendanceRequestResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meeting-attendance-requests")
public class MeetingAttendanceRequestController {

    private final GetAllMeetingAttendanceRequestsApplicationService getAllMeetingAttendanceRequestsApplicationService;
    @GetMapping()
    public ResponseEntity<List<MeetingAttendanceRequestResponseDTO>> getAllMeetingAttendanceRequests() throws Exception {
        return new ResponseEntity<>(getAllMeetingAttendanceRequestsApplicationService.getAllMeetingAttendanceRequests(), HttpStatus.OK);
    }
}
