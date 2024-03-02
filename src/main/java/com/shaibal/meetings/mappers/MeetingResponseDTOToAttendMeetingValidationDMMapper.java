package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.ValidateAttendMeetingInputDM;
import com.shaibal.meetings.models.MeetingResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MeetingResponseDTOToAttendMeetingValidationDMMapper implements IMapper<ValidateAttendMeetingInputDM, MeetingResponseDTO> {
    @Override
    public ValidateAttendMeetingInputDM map(MeetingResponseDTO src) {
        ValidateAttendMeetingInputDM validateAttendMeetingInputDM = new ValidateAttendMeetingInputDM();

        validateAttendMeetingInputDM.setMeetingEndTime(src.getEndTime());
        validateAttendMeetingInputDM.setMeetingStartTime(src.getStartTime());
        validateAttendMeetingInputDM.setIsAllowingAttendanceAfterStartTime(src.getIsAllowingAttendanceAfterStartTime());
        validateAttendMeetingInputDM.setMinAge(src.getMinAge());
        validateAttendMeetingInputDM.setMaxAge(src.getMaxAge());
        validateAttendMeetingInputDM.setCurrentNumOfAttendees(src.getCurrentNumOfAttendees());
        validateAttendMeetingInputDM.setIsAllowingAttendanceAfterStartTime(src.getIsAllowingAttendanceAfterStartTime());

        return validateAttendMeetingInputDM;
    }
}
