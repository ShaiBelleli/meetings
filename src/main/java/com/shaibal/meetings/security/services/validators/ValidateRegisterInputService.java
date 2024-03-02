package com.shaibal.meetings.security.services.validators;

import com.shaibal.meetings.security.models.ValidateRegisterInputDM;
import com.shaibal.meetings.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ValidateRegisterInputService {

    @Value("${configuration.regex.email}")
    private String EMAIL_REGEX;

    @Value("${configuration.regex.password}")
    private String PASSWORD_REGEX;

    @Value("${configuration.regex.instagramUrl}")
    private String INSTAGRAM_URL_REGEX;

    private final UserRepository userRepository;
    public void validate(ValidateRegisterInputDM requestParameters) throws BadRequestException {
        String email = requestParameters.getEmail();
        String password = requestParameters.getPassword();
        String instagramUrl = requestParameters.getInstagramUrl();
        Integer age = requestParameters.getAge();
        String displayName = requestParameters.getDisplayName();

        validateEmail(email);
        validatePassword(password);
        validateInstagramUrlRegex(instagramUrl);
        validateAge(age);
        validateDisplayName(displayName);
    }

    private void validateEmail(String email) throws BadRequestException {
        validateFieldNotEmpty("Email", email);
        validateEmailRegex(email);
        validateEmailIsUnique(email);
    }

    private void validateEmailRegex(String email) throws BadRequestException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new BadRequestException("Email address invalid.");
        }
    }

    private void validateEmailIsUnique(String email) throws BadRequestException {
        if (userRepository.existsByEmail(email)) {
            throw new BadRequestException("Email address is already in use.");
        }
    }

    private void validatePassword(String password) throws BadRequestException {
        validateFieldNotEmpty("Password", password);
        validatePasswordRegex(password);
    }

    private void validatePasswordRegex(String password) throws BadRequestException {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            throw new BadRequestException("Password length must be between 8 and 14 characters, contain at least one uppercase letter and one lowercase letter.");
        }
    }

    private void validateAge(Integer age) throws BadRequestException {
        validateFieldNotEmpty("Age", age);

        if (age < 6) {
            throw new BadRequestException("Invalid age");
        }
    }

    private void validateInstagramUrlRegex(String instagramUrl) throws BadRequestException {
        if (instagramUrl != null) {
            Pattern pattern = Pattern.compile(INSTAGRAM_URL_REGEX);
            Matcher matcher = pattern.matcher(instagramUrl);

            if (!matcher.matches()) {
                throw new BadRequestException("Instagram URL invalid");
            }
        }
    }

    private void validateDisplayName(String displayName) throws BadRequestException {
        validateFieldNotEmpty("Display name", displayName);
        validateDisplayNameIsUnique(displayName);
    }

    private <T> void validateFieldNotEmpty(String fieldName, T field) {
        if (field == null || (field instanceof CharSequence && ((CharSequence) field).isEmpty())) {
            throw new IllegalArgumentException(fieldName + " must not be empty");
        }
    }

    private void validateDisplayNameIsUnique(String displayName) throws BadRequestException {
        if (userRepository.existsByDisplayName(displayName)) {
            throw new BadRequestException("Display name is already in use.");
        }
    }
}
