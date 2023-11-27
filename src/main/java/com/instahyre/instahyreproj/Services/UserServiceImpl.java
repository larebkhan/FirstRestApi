package com.instahyre.instahyreproj.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instahyre.instahyreproj.dao.ContactRepository;
import com.instahyre.instahyreproj.dao.SpamReportRepository;
import com.instahyre.instahyreproj.dao.UserRepository;
import com.instahyre.instahyreproj.entities.Contact;
import com.instahyre.instahyreproj.entities.SpamReport;
import com.instahyre.instahyreproj.entities.User;

@Service
public class UserServiceImpl implements UserService {

     @Autowired
    private SpamReportRepository spamReportRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public User registerUser(User user) {
        // Your registration logic goes here, e.g., validate uniqueness of phone number
        if (userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new IllegalArgumentException("User with this phone number already exists");
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> searchByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<User> searchByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public void markNumberAsSpam(User reporter, String phoneNumber) {
        SpamReport spamReport = new SpamReport();
        spamReport.setReporter(reporter);
        spamReport.setReportedNumber(phoneNumber);
        spamReportRepository.save(spamReport);
    }

    @Override
    public void addContact(Long userId, Contact contact) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            contact.setUser(user);
            contactRepository.save(contact);
        } else {
            // Handle the case where the user with the given ID is not found
        }
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
        //throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}