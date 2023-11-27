package com.instahyre.instahyreproj.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instahyre.instahyreproj.Services.ContactService;
import com.instahyre.instahyreproj.entities.Contact;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable Long userId) {
        List<Contact> contacts = contactService.getUserContacts(userId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    // Additional endpoints
}