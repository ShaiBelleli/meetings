package com.shaibal.meetings.services.validators;

import com.shaibal.meetings.models.MeetingRequestDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidateAddMeetingService {

    public void validate(MeetingRequestDTO meetingRequestDTO) {
        LocalDateTime startDate = meetingRequestDTO.getStartTime();

        validateStartDateHasNotExpired(startDate);
    }

    private void validateStartDateHasNotExpired(LocalDateTime startDate) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (startDate.isBefore(currentDateTime)) {
            throw new IllegalArgumentException("Meeting start date has already expired");
        }
    }

}
