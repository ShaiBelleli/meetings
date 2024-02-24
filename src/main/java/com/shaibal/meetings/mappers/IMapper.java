package com.shaibal.meetings.mappers;

import com.shaibal.meetings.models.MeetingDM;
import com.shaibal.meetings.models.MeetingResponseDTO;

public interface IMapper<R, S> {
    R map(S src);
}
