package com.instahyre.instahyreproj.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instahyre.instahyreproj.Services.UserService;
import com.instahyre.instahyreproj.entities.User;
import com.instahyre.instahyreproj.entities.UserRegistrationDto;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        // Registration endpoint logic
        User user = new User();
        user.setName(registrationDto.getName());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setEmail(registrationDto.getEmail());
        user.setUserProvidedPassword(registrationDto.getPassword());

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Additional endpoints
}
