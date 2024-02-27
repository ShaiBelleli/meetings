package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.models.Location;
import com.shaibal.meetings.models.MeetingRequestDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidateAddMeetingService {

    public void validate(MeetingRequestDTO meetingRequestDTO) throws BadRequestException {
        LocalDateTime startDate = meetingRequestDTO.getStartTime();

        validateNonNullFields(meetingRequestDTO);
        validateStartDateHasNotExpired(startDate);
    }

    private void validateStartDateHasNotExpired(LocalDateTime startDate) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (startDate.isBefore(currentDateTime)) {
            throw new IllegalArgumentException("Meeting start date has already expired");
        }
    }

    private void validateNonNullFields(MeetingRequestDTO meetingRequestDTO) throws BadRequestException {
        String title = meetingRequestDTO.getTitle();
        LocalDateTime startTime = meetingRequestDTO.getStartTime();
        Location location = meetingRequestDTO.getLocation();

        if (title == null) {
            throw new BadRequestException("title field is mandatory, but missing");
        }

        if (startTime == null) {
            throw new BadRequestException("startTime field is mandatory, but missing");
        }

        if (location == null) {
            throw new BadRequestException("location field is mandatory, but missing");
        }
    }

}
