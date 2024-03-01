package com.shaibal.meetings.security.application_service;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.models.AuthenticationResponseDTO;
import com.shaibal.meetings.security.models.LoginRequestDTO;
import com.shaibal.meetings.security.steps.LoginUserStep;
import com.shaibal.meetings.security.steps.validators.ValidateLoginInputStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUserApplicationService {
    private final ValidateLoginInputStep validateLoginInputStep;
    private final LoginUserStep loginUserStep;

    public AuthenticationResponseDTO login(LoginRequestDTO request) throws Exception {
        SecurityContext context = initContext(request);

        validateLoginInputStep.execute(context);
        loginUserStep.execute(context);

        return (AuthenticationResponseDTO) context.getValue(SecurityContextConstants.LOGIN_RESPONSE_DTO);
    }

    private SecurityContext initContext(LoginRequestDTO request) {
        SecurityContext context = new SecurityContext();

        context.setValue(SecurityContextConstants.LOGIN_REQUEST_DTO, request);

        return context;
    }
}
