package com.shaibal.meetings.security.services;

import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final JwtService jwtService;

    public String registerUser(User user) {
        return jwtService.generateToken(user);
    }
}
