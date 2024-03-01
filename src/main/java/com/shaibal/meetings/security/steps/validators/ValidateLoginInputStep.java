package com.shaibal.meetings.security.steps.validators;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.models.LoginRequestDTO;
import com.shaibal.meetings.security.models.ValidateLoginInputDM;
import com.shaibal.meetings.security.models.ValidateRegisterInputDM;
import com.shaibal.meetings.security.services.validators.ValidateLoginInputService;
import com.shaibal.meetings.security.steps.IStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateLoginInputStep implements IStep {
    private final ValidateLoginInputService validateLoginInputService;

    @Override
    public void execute(SecurityContext context) throws Exception {
        LoginRequestDTO request = (LoginRequestDTO) context.getValue(SecurityContextConstants.LOGIN_REQUEST_DTO);

        ValidateLoginInputDM validateLoginInputDM = buildValidateLoginInputDM(request);

        validateLoginInputService.validate(validateLoginInputDM);
    }

    private ValidateLoginInputDM buildValidateLoginInputDM(LoginRequestDTO request) {
        ValidateLoginInputDM validateLoginInputDM = new ValidateLoginInputDM();

        validateLoginInputDM.setEmail(request.getEmail());
        validateLoginInputDM.setPassword(request.getPassword());

        return validateLoginInputDM;
    }
}
