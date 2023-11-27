package com.instahyre.instahyreproj.Services;

import java.util.List;

import com.instahyre.instahyreproj.entities.Contact;
import com.instahyre.instahyreproj.entities.User;

public interface ContactService {
    List<Contact> getUserContacts(Long userId);
    boolean isContact(User user, User contact);
    void addContact(User user, Contact newContact);
    void removeContact(User user, Long contactId);
    boolean existsByUserAndPhoneNumber(User user, String phoneNumber);
    // Additional methods
    void save(Contact contact);
}
