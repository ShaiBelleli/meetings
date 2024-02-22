package com.shaibal.meetings.controllers;

import com.shaibal.meetings.models.MeetingRequestDTO;
import com.shaibal.meetings.models.MeetingResponseDTO;
import com.shaibal.meetings.delegates.MeetingDelegate;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeetingController {

    private final MeetingDelegate meetingDelegate;

    public MeetingController(MeetingDelegate meetingDelegate) {
        this.meetingDelegate = meetingDelegate;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/meetings")
    public ResponseEntity<List<MeetingResponseDTO>> getAllMeetings() {
        return new ResponseEntity<>(meetingDelegate.getAllMeetings(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<MeetingResponseDTO> add(@RequestBody MeetingRequestDTO meetingRequestDTO) {
        return new ResponseEntity<>(meetingDelegate.addMeeting(meetingRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteMeetingById(@RequestParam Long meetingId) throws Exception {
        return new ResponseEntity<>(meetingDelegate.deleteMeetingById(meetingId), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> attendMeeting(@RequestParam Long meetingId) throws Exception {
        return new ResponseEntity<>(meetingDelegate.attendMeeting(meetingId), HttpStatus.OK);
    }
}
