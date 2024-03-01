package com.shaibal.meetings.security.services.validators;

import com.shaibal.meetings.security.models.ValidateLoginInputDM;
import com.shaibal.meetings.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateLoginInputService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    public void validate(ValidateLoginInputDM validateLoginInputDM) throws BadRequestException {
        authenticateUser(validateLoginInputDM);
        validateEmailExistsInDb(validateLoginInputDM.getEmail());
    }

    private void authenticateUser(ValidateLoginInputDM validateLoginInputDM) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                validateLoginInputDM.getEmail(),
                validateLoginInputDM.getPassword()
        ));
    }

    public void validateEmailExistsInDb(String email) throws UsernameNotFoundException {
        if (!userRepository.existsByEmail(email)) {
            throw new UsernameNotFoundException("Email does not exist.");
        }
    }
}
