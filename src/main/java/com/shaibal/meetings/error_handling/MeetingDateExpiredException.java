package com.shaibal.meetings.error_handling;

import lombok.Getter;

@Getter
public class MeetingDateExpiredException extends RuntimeException {

    private String message;

    public MeetingDateExpiredException() {

    }
    public MeetingDateExpiredException(String message) {
        this.message = message;
    }
}
