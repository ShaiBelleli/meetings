package com.shaibal.meetings.controllers;

import com.shaibal.meetings.application_services.*;
import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeetingController {

    private final GetAllMeetingsApplicationService getAllMeetingsApplicationService;
    private final AddMeetingApplicationService addMeetingApplicationService;
    private final DeleteMeetingByIdApplicationService deleteMeetingByIdApplicationService;
    private final AttendMeetingApplicationService attendMeetingApplicationService;
    private final GetMeetingApplicationService getMeetingApplicationService;


    public MeetingController(GetAllMeetingsApplicationService getAllMeetingsApplicationService, AddMeetingApplicationService addMeetingApplicationService, DeleteMeetingByIdApplicationService deleteMeetingByIdApplicationService, AttendMeetingApplicationService attendMeetingApplicationService, GetMeetingApplicationService getMeetingApplicationService) {
        this.getAllMeetingsApplicationService = getAllMeetingsApplicationService;
        this.addMeetingApplicationService = addMeetingApplicationService;
        this.deleteMeetingByIdApplicationService = deleteMeetingByIdApplicationService;
        this.attendMeetingApplicationService = attendMeetingApplicationService;
        this.getMeetingApplicationService = getMeetingApplicationService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/meetings")
    public ResponseEntity<List<MeetingResponseDTO>> getAllMeetings() {
        return new ResponseEntity<>(getAllMeetingsApplicationService.getAllMeetings(), HttpStatus.OK);
    }

    @GetMapping("/meetings/{id}")
    public ResponseEntity<MeetingResponseDTO> getMeetingById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getMeetingApplicationService.getMeeting(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<MeetingResponseDTO> add(
            @RequestBody MeetingRequestDTO meetingRequestDTO,
            @RequestHeader(value = HttpHeaders.AUTHORIZATION) String jwtToken) throws Exception {
        return new ResponseEntity<>(addMeetingApplicationService.addMeeting(meetingRequestDTO, jwtToken), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteMeetingById(@NonNull @RequestParam String meetingId) throws Exception {
        return new ResponseEntity<>(deleteMeetingByIdApplicationService.deleteMeeting(meetingId), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> attendMeeting(@RequestParam String meetingId) throws Exception {
        return new ResponseEntity<>(attendMeetingApplicationService.attendMeeting(meetingId), HttpStatus.OK);
    }
}
