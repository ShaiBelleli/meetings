package com.shaibal.meetings.security.steps;

import com.shaibal.meetings.security.SecurityContext;

public interface IStep {
    public void execute(SecurityContext context) throws Exception;
}
