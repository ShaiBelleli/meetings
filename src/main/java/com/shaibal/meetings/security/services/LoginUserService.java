package com.shaibal.meetings.security.services;

import com.shaibal.meetings.security.repository.UserRepository;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserService {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public String login(User user) {
        return jwtService.generateToken(user);
    }

    public User getUserFromDbByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
