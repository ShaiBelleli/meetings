package com.shaibal.meetings.security.services;

import com.shaibal.meetings.security.repository.UserRepository;
import com.shaibal.meetings.security.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistUserService {
    private final UserRepository userRepository;
    public void save(User user) {
        userRepository.save(user);
    }
}
