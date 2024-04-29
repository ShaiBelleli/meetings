package com.shaibal.meetings.controllers;

import com.shaibal.meetings.application_services.*;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final GetAllMeetingsApplicationService getAllMeetingsApplicationService;
    private final AddMeetingApplicationService addMeetingApplicationService;
    private final DeleteMeetingByIdApplicationService deleteMeetingByIdApplicationService;
    private final AttendMeetingApplicationService attendMeetingApplicationService;
    private final GetMeetingApplicationService getMeetingApplicationService;

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MeetingResponseDTO>> getAllMeetings() {
        return new ResponseEntity<>(getAllMeetingsApplicationService.getAllMeetings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingResponseDTO> getMeetingById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getMeetingApplicationService.getMeeting(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<MeetingResponseDTO> add(
            @RequestBody MeetingRequestDTO meetingRequestDTO,
            @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authHeader) throws Exception {
        return new ResponseEntity<>(addMeetingApplicationService.addMeeting(meetingRequestDTO, authHeader), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeetingById(@NonNull @PathVariable String id) throws Exception {
        return new ResponseEntity<>(deleteMeetingByIdApplicationService.deleteMeeting(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> attendMeeting(@PathVariable String id,
                                                @RequestHeader(value = HttpHeaders.AUTHORIZATION) String authHeader) throws Exception {
        return new ResponseEntity<>(attendMeetingApplicationService.attendMeeting(id, authHeader), HttpStatus.OK);
    }

//    @GetMapping()
//    public ResponseEntity<List<PendingMeetingResponseDTO>> getPendingMeetings() {
//
//    }
}
