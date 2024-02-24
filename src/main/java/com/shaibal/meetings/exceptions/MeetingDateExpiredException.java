package com.shaibal.meetings.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MeetingDateExpiredException extends RuntimeException {

    private String message;

    public MeetingDateExpiredException() {

    }
    public MeetingDateExpiredException(String message) {
        this.message = message;
    }
}
