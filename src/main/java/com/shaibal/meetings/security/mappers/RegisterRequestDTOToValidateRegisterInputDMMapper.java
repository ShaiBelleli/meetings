package com.shaibal.meetings.security.mappers;

import com.shaibal.meetings.mappers.IMapper;
import com.shaibal.meetings.security.models.RegisterRequestDTO;
import com.shaibal.meetings.security.models.ValidateRegisterInputDM;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequestDTOToValidateRegisterInputDMMapper implements IMapper<ValidateRegisterInputDM, RegisterRequestDTO> {
    @Override
    public ValidateRegisterInputDM map(RegisterRequestDTO src) {
        ValidateRegisterInputDM validateRegisterInputDM = new ValidateRegisterInputDM();

        validateRegisterInputDM.setAge(src.getAge());
        validateRegisterInputDM.setEmail(src.getEmail());
        validateRegisterInputDM.setDisplayName(src.getDisplayName());
        validateRegisterInputDM.setInstagramUrl(src.getInstagramUrl());
        validateRegisterInputDM.setPassword(src.getPassword());

        return validateRegisterInputDM;
    }
}

