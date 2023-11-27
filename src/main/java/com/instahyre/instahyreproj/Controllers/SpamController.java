package com.instahyre.instahyreproj.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instahyre.instahyreproj.Services.SpamService;
import com.instahyre.instahyreproj.entities.User;

@RestController
@RequestMapping("/api/spam")
public class SpamController {

    @Autowired
    private SpamService spamService;

    @PostMapping("/mark")
    public ResponseEntity<Void> markNumberAsSpam(@RequestParam Long userId, @RequestParam String reportedNumber) {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Assuming proper authentication logic
        if (authentication == null || !authentication.isAuthenticated()) {
            // Not authenticated or not authorized
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        User user = (User) authentication.getPrincipal();
        spamService.markNumberAsSpam(user, reportedNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Additional endpoints
}
