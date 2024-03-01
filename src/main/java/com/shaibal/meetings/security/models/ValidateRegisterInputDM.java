package com.shaibal.meetings.security.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ValidateRegisterInputDM {
    private String email;
    private String password;
    private String instagramUrl;
}
