package com.shaibal.meetings.security.application_service;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.models.AuthenticationResponseDTO;
import com.shaibal.meetings.security.models.RegisterRequestDTO;
import com.shaibal.meetings.security.steps.RegisterUserStep;
import com.shaibal.meetings.security.steps.PersistUserStep;
import com.shaibal.meetings.security.steps.validators.ValidateRegisterInputStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserApplicationService {

    private final ValidateRegisterInputStep validateInputStep;
    private final RegisterUserStep registerUserStep;
    private final PersistUserStep persistUserStep;

    public AuthenticationResponseDTO register(RegisterRequestDTO request) throws Exception {
        SecurityContext context = initContext(request);

        validateInputStep.execute(context);
        registerUserStep.execute(context);
        persistUserStep.execute(context);

        return (AuthenticationResponseDTO) context.getValue(SecurityContextConstants.REGISTER_RESPONSE_DTO);
    }

    private SecurityContext initContext(RegisterRequestDTO request) {
        SecurityContext securityContext = new SecurityContext();

        securityContext.setValue(SecurityContextConstants.REGISTER_REQUEST_DTO, request);

        return securityContext;
    }
}
