package com.shaibal.meetings.security.steps;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.services.SaveUserToDbService;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserToDbStep implements IStep {

    private final SaveUserToDbService saveUserToDbService;

    @Override
    public void execute(SecurityContext context) throws Exception {
        User user = (User) context.getValue(SecurityContextConstants.USER);

        saveUserToDbService.save(user);
    }
}
