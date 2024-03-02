package com.shaibal.meetings.security.steps.validators;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.mappers.RegisterRequestDTOToValidateRegisterInputDMMapper;
import com.shaibal.meetings.security.models.RegisterRequestDTO;
import com.shaibal.meetings.security.models.ValidateRegisterInputDM;
import com.shaibal.meetings.security.services.validators.ValidateRegisterInputService;
import com.shaibal.meetings.security.steps.IStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateRegisterInputStep implements IStep {
    private final ValidateRegisterInputService validateRegisterInputService;
    private final RegisterRequestDTOToValidateRegisterInputDMMapper registerRequestDTOToValidateRegisterInputDMMapper;
    public void execute(SecurityContext context) throws Exception {
        RegisterRequestDTO request = (RegisterRequestDTO) context.getValue(SecurityContextConstants.REGISTER_REQUEST_DTO);

        ValidateRegisterInputDM validateRegisterInputDM = registerRequestDTOToValidateRegisterInputDMMapper.map(request);

        validateRegisterInputService.validate(validateRegisterInputDM);
    }
}
