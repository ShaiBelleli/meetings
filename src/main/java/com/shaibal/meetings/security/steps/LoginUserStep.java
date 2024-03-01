package com.shaibal.meetings.security.steps;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.models.AuthenticationResponseDTO;
import com.shaibal.meetings.security.models.LoginRequestDTO;
import com.shaibal.meetings.security.services.LoginUserService;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUserStep implements IStep {

    private final LoginUserService loginUserService;

    @Override
    public void execute(SecurityContext context) throws Exception {
        LoginRequestDTO request = (LoginRequestDTO) context.getValue(SecurityContextConstants.LOGIN_REQUEST_DTO);

        String userEmail = request.getEmail();

        User user = loginUserService.getUserFromDbByEmail(userEmail);

        String jwtToken = loginUserService.login(user);

        AuthenticationResponseDTO loginResponse = new AuthenticationResponseDTO(jwtToken);

        context.setValue(SecurityContextConstants.LOGIN_RESPONSE_DTO, loginResponse);
    }
}
