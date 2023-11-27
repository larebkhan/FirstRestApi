package com.instahyre.instahyreproj.entities;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegistrationDto userDto = (UserRegistrationDto) target;

        // Custom validation logic can be added here
        // For example, checking if the password meets certain criteria

        // Sample validation (password should be at least 8 characters long)
        if (userDto.getPassword().length() < 8) {
            errors.rejectValue("password", "Password must be at least 8 characters long");
        }
    }
}
