package com.shaibal.meetings.security.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDTO {
    private String firstName;
    private String lastName;
    private String instagramUrl;
    private String displayName;
    private String email;
    private String password;
    private Integer age;
    private String freeText;
}
