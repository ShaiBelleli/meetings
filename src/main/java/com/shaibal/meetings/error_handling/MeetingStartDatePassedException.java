package com.shaibal.meetings.error_handling;

import lombok.Getter;

@Getter
public class MeetingStartDatePassedException extends RuntimeException {

    private String message;
    public MeetingStartDatePassedException(){}
    public MeetingStartDatePassedException(String message) {
        this.message = message;
    }
}
