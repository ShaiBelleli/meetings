package com.shaibal.meetings.security.controller;

import com.shaibal.meetings.security.application_service.LoginUserApplicationService;
import com.shaibal.meetings.security.application_service.RegisterUserApplicationService;
import com.shaibal.meetings.security.models.LoginRequestDTO;
import com.shaibal.meetings.security.models.AuthenticationResponseDTO;
import com.shaibal.meetings.security.models.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final RegisterUserApplicationService registerUserApplicationService;
    private final LoginUserApplicationService loginUserApplicationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) throws Exception {
        return new ResponseEntity<>(registerUserApplicationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody LoginRequestDTO request) throws Exception {
        return new ResponseEntity<>(loginUserApplicationService.login(request), HttpStatus.OK);
    }
}
