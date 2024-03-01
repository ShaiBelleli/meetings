package com.shaibal.meetings.error_handling;

import lombok.Getter;

@Getter
public class MaximumNumberOfPeopleReachedException extends RuntimeException {
    private String message;

    public MaximumNumberOfPeopleReachedException() {}
    public MaximumNumberOfPeopleReachedException(String msg) {
        this.message = msg;
    }
}
