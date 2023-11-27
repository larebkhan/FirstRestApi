package com.instahyre.instahyreproj.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instahyre.instahyreproj.dao.ContactRepository;
import com.instahyre.instahyreproj.entities.Contact;
import com.instahyre.instahyreproj.entities.User;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getUserContacts(Long userId) {
        // Your logic to retrieve user contacts goes here
        return contactRepository.findByUser(new User(userId));
    }

    @Override
    public boolean isContact(User user, User contact) {
        // Your logic to check if contact exists for the user goes here
        return contactRepository.findByUserAndName(user, contact.getName()).isPresent();
    }

    @Override
    public void addContact(User user, Contact newContact) {
        // Your logic to add a new contact goes here
        newContact.setUser(user);
        contactRepository.save(newContact);
    }

    @Override
    public void removeContact(User user, Long contactId) {
        // Your logic to remove a contact goes here
        contactRepository.deleteById(contactId);
    }
    @Override
    public boolean existsByUserAndPhoneNumber(User user, String phoneNumber) {
        return contactRepository.existsByUserAndPhoneNumber(user, phoneNumber);
    }

    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public String toString() {
        return "ContactServiceImpl [contactRepository=" + contactRepository + "]";
    }

    @Override
public void save(Contact contact) {
    contactRepository.save(contact);
}
}
