package com.shaibal.meetings.security.steps;

import com.shaibal.meetings.security.SecurityContext;
import com.shaibal.meetings.security.config.SecurityContextConstants;
import com.shaibal.meetings.security.models.AuthenticationResponseDTO;
import com.shaibal.meetings.security.models.RegisterRequestDTO;
import com.shaibal.meetings.security.services.RegisterUserService;
import com.shaibal.meetings.security.users.Role;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserStep implements IStep {

    private final RegisterUserService registerUserService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void execute(SecurityContext context) throws Exception {
        RegisterRequestDTO request = (RegisterRequestDTO) context.getValue(SecurityContextConstants.REGISTER_REQUEST_DTO);

        User user = buildUser(request);

        context.setValue(SecurityContextConstants.USER, user);

        String jwtToken = registerUserService.registerUser(user);

        AuthenticationResponseDTO registerResponse = new AuthenticationResponseDTO(jwtToken);

        context.setValue(SecurityContextConstants.REGISTER_RESPONSE_DTO, registerResponse);
    }

    private User buildUser(RegisterRequestDTO request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .displayName(request.getDisplayName())
                .instagramUrl(request.getInstagramUrl())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.GUEST)
                .build();
    }
}
